package com.pingwit.part_31.thread;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());
        System.out.println(mainThread.getThreadGroup().getName());

//        mainThread.interrupt();
        System.out.println("mainThread.isAlive():" + mainThread.isAlive());

        ParallelPrinter parallelPrinter = new ParallelPrinter("ParallelPrinter-1");
        parallelPrinter.start();

        ParallelPrinter extraPrinter = new ParallelPrinter("ParallelPrinter-2");
        extraPrinter.start();

        parallelPrinter.join();
        extraPrinter.join();

        mainThread.notifyAll();
        System.out.println("Main thread finished");

        /*
        notify():
        - Когда вызывается метод notify() у объекта, другой поток, который ожидает доступ к тому же объекту монитора с помощью метода wait(),
         будет оповещен и может продолжить свою работу.

        - Поток, который был оповещен методом notify(), будет перемещен из состояния ожидания (WAITING или TIMED_WAITING) в состояние готовности (RUNNABLE).
        Однако он не сразу начнет выполняться, а продолжит выполнение, как только поток, вызвавший notify(), освободит монитор.

        - Метод notify() не освобождает монитор объекта. Это означает, что другой поток все еще не может получить доступ к монитору,
        пока текущий поток не завершит выполнение синхронизированной области кода или не освободит монитор явно, например,
         вызвав wait() или выйдя из синхронизированного блока.
         */

        /*
        notifyAll()
        Метод notifyAll() используется для оповещения всех потоков, которые ожидают доступа к объекту монитора.
        Все потоки, которые были заблокированы на этом мониторе, будут оповещены и перемещены из состояния ожидания в состояние готовности.
        После вызова notifyAll() каждый поток будет соревноваться за доступ к монитору снова,
        и только один поток будет успешным в захвате монитора и продолжит выполнение.
         */

        /*
        Монитор
        В контексте многопоточности в Java термин "монитор" обозначает механизм,
        который обеспечивает синхронизацию доступа к общим ресурсам или критическим секциям кода.
        Мониторы в Java тесно связаны с ключевым словом synchronized и используются для обеспечения потокобезопасности в многопоточных приложениях.
         */
    }
}
