package lesson31;

/*
Проблематика
1. Пользовательский интерфейс однопоточный
    AWT,Swing,JavaFx
    Android
2. Стандартные классы для работы с многопочностью в яве неудобны
3. Все современные процессоры многоядерные
4. Имеется несколько распространненых библиотек для более удобной работы с многопоточностью
    RxJava3 - java, kotlin, android
    Reactor - spring, kotlin, android
    Coroutine - kotlin, android
5. "Поток"
    stream
    iostream
    thread

Терминология
Процесс - Process - выполняющаяся программа
Рост производительности
    Увеличить количество CPU - Central Processing Unit - процессор
    Увеличить тактовую частоту
    Увеличить количество ядер на CPU
        Ядро - Core - возможность параллельного выполнения какого-нибудь метода программы
    Поток выполнения, Thread, "Нить" - параллельно выполняющаяся функция

Основной поток - поток выполнения который получается при старте программы, 1
Порожденный поток - поток выполнения, запущенный из основного или другого порожденного (другой идентификатор)
 */
public class ThreadIntro {
    public static void main(String[] args) {
        // у каждого потока выполнения есть свой идентификатор
        System.out.println("Main thread id is: " + Thread.currentThread().getId()); // Main thread id is: 1

        // сколько ядер
        // Runtime - класс для запросов по железу и ОС, а также команд для ОС
        System.out.println(Runtime.getRuntime().availableProcessors()); // 12

        // Создание пустого потока
        Thread t1 = new Thread();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                // полезная работа, которую хотим выполнить в порожденном потоке
                System.out.println("Thread with id: " + Thread.currentThread().getId());
            }
        };
        // запуск порожденного потока на выполнение
        t2.start(); // Thread with id: 13
        // t2.start(); - IllegalThreadStateException

        // Runnable - работа, которая может быть выполнена в порожденном потоке (и повторно использована)
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread from runnable, id: " + Thread.currentThread().getId());
            }
        };
        new Thread(r1).start(); // Thread from runnable, id: 14
        new Thread(r1).start(); // Thread from runnable, id: 15

        // main по-умолчанию дожидается окончания выполнения всех его порожденных потоков
        new Thread() {
            @Override
            public void run() {
                System.out.println("Slow thread start, id: " + Thread.currentThread().getId());
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Slow thread end, id: " + Thread.currentThread().getId());
            }
        }.start();

        // можно "демонизировать" поток выполнения и тогда main не будет его ждать
        Thread daemonThread = new Thread() {
            @Override
            public void run() {
                System.out.println("Daemon thread start, id: " + Thread.currentThread().getId());
                try {
                    Thread.sleep(5_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Daemon thread end, id: " + Thread.currentThread().getId());
            }
        };
        daemonThread.setDaemon(true); // демонизация - main не будет его ждать
        // приоритет влияет на долю времени,
        // выделяемого потоку на выполнение
        daemonThread.setPriority(Thread.MAX_PRIORITY);
        daemonThread.start();

        Runnable work = ThreadIntro::someWork;
        Thread anotherDaemonThread = new Thread(work);
        anotherDaemonThread.setDaemon(true);
        anotherDaemonThread.start();
    }
    public static void someWork()
    {
        System.out.println("Another daemon thread start, id: " + Thread.currentThread().getId());
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Another daemon thread end, id: " + Thread.currentThread().getId());
    }
}