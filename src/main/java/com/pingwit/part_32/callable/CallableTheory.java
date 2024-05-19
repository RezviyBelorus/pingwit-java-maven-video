package com.pingwit.part_32.callable;

public class CallableTheory {
    public static void main(String[] args) {
        /*
        Интерфейс Callable в Java похож на интерфейс Runnable,
        но предоставляет возможность вернуть результат выполнения потока и бросить исключение,
        если выполнение потока завершилось неудачно.
        Callable определен в пакете java.util.concurrent.
         */

        /*
        Основные отличия интерфейса Callable от Runnable:
        - Возвращаемое значение: Метод call() интерфейса Callable может возвращать результат своего выполнения,
         который имеет тип V. В отличие от Runnable, который ничего не возвращает.

        - Исключения: Метод call() интерфейса Callable объявляет throws Exception, что позволяет потоку бросать исключения.
         В Runnable метод run() не может бросить проверяемые исключения.
         */
    }
}
