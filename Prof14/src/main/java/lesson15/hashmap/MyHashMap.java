package lesson15.hashmap;

public class MyHashMap implements MyMap {

    private int size = 0; // количество пар в мапе

    private static class Pair {
        String key;
        String value;
        Pair next; // ссылка на следующую пару

        public Pair(String key, String value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + key + ":" + value + "}";
        }
    }

    // хэш-функция
    // Object -> int
    // получение индекса ведра
    // int % source.length

    // начальный размер массива
    private static final int
            INITIAL_CAPACITY = 4;

    // массив с парами
    private Pair[] source = new Pair[
            INITIAL_CAPACITY];

    // коэффициент загрузки
    // если size > LOAD_FACTOR * source.length
    // от мапу нужно перебалансировать
    // пербансировка это создание массива в 2 раза
    // больше и копирование туда пар
    private static final double
            LOAD_FACTOR = 0.75;

    @Override
    public int size() {
        return size;
    }

    // вычисление номера вебра по ключу
    private int findBucket(String key) {
        return Math.abs(
                key.hashCode()
        ) % source.length;
    }

    // нахождение пары по ключу
    private Pair findPair(String key) {
        int bucket = findBucket(key);
        Pair current = source[bucket];
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }


    @Override
    public boolean contains(String key) {
        return findPair(key) != null;
    }

    @Override
    public void put(String key, String value) {
        if (size() > LOAD_FACTOR * source.length)
            rebalance();
        Pair pair = findPair(key);
        if (pair != null) {
            // просто меняем значение
            pair.value = value;
        } else {
            int bucket = findBucket(key);
            source[bucket] = new Pair(
                    key,
                    value,
                    source[bucket] // та что была раньше
            );
            size++;
        }
    }

    private void rebalance() {
        Pair[] newSource = new Pair[2*source.length];
        for(Pair p: source)
        {
            Pair current = p;
            while (current != null)
            {
                Pair next = current.next;
                int bucket = Math.abs(current.key.hashCode()) % newSource.length;
                current.next = newSource[bucket];
                newSource[bucket] = current;
                current = next;
            }
        }
        source = newSource;

//        Pair[] bigSource = new Pair[source.length * 2];
//        for (int i = 0; i < source.length; i++) {
//            if (source[i] != null) {
//                Pair current = source[i];
//                int bucket = Math.abs(current.key.hashCode()) % bigSource.length;
//                if (bigSource[bucket] != null) {
//                    current.next = bigSource[bucket];
//                    bigSource[bucket] = current;
//                } else {
//                    bigSource[bucket] = current;
//                }
//            }
//        }
//        source = bigSource;
    }

    @Override
    public String get(String key) {
        if (findPair(key) != null) {
            return findPair(key).value;
        }
        return null;
    }

    @Override
    public String remove(String key) {
        int bucket = findBucket(key);
        Pair current = source[bucket];
        if(current == null)
            return null;
        if(current.key.equals(key))
        {
            source[bucket] = current.next;
            size--;
            return current.value;
        }
        while (current.next != null)
        {
            if(current.next.key.equals(key))
            {
                Pair toDelete = current.next;
                current.next = toDelete.next;
                size--;
                return toDelete.value;
            }
            current = current.next;
        }
        return null;

//        String s = "";
//        if (!contains(key)) {
//            return null;
//        } else {
//            int bucket = findBucket(key);
//            if (source[bucket].key.equals(key)) {
//                source[bucket] = source[bucket].next;
//                size--;
//            } else {
//                Pair tmp = source[bucket];
//                while (!tmp.next.key.equals(key)) {
//                    tmp=tmp.next;
//                }
//                s=tmp.next.value;
//                tmp.next = tmp.next.next;
//                size--;
//            }
//        }
//        return s;
    }

    @Override
    public String toString() {
        String r = "[";
        int s = size() - 1;
        for (Pair p : source) {
            Pair current = p;
            while (current != null) {
                r += p;
                if (--s >= 0)
                    r += ", ";
                current = current.next;
            }
        }
        return r;
    }
}
