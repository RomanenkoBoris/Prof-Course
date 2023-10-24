package lesson33.containers;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapTester {
    public static void main(String[] args) throws Exception {
        // HashMap не является потокобезопасным!
        // Map<String, Integer> map = new HashMap<>();
        // Map<String, Integer> map = new Hashtable<String , Integer>(); // Hashtable
        // Map<String, Integer> map = new ConcurrentHashMap<>();
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        // List<String> names = new ArrayList<>(); // не потокобезопасный контейнер
        // List<String> names = new Vector<>(); // потокобезопасный контейнер, но медленный
        List<String> names = Collections.synchronizedList(new ArrayList<>()); // обертка потокобезопасная

        Set<String> countries = Collections.synchronizedSet(new HashSet<>()); // потокобезопасная обертка

        System.out.println(
                parallelAdd(map, 100)
        );
    }

    private static List<Integer> parallelAdd(Map<String, Integer> map, int times) throws Exception
    {
        List<Integer> result = new ArrayList<>(); // times значений
        for(int i = 0; i < times; i++)
        {
            map.put("test", 0);
            ExecutorService service = Executors.newFixedThreadPool(4);
            for(int j = 0; j< 10; j++)
            {
                service.submit(
                        () -> {
                            for(int k = 0; k < 10; k++)
                            {
                                map.computeIfPresent(
                                        "test",
                                        (key, value) -> value + 1
                                );
                            }
                        }
                );
            }
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
            result.add(map.get("test"));
        }
        return result;
    }
}