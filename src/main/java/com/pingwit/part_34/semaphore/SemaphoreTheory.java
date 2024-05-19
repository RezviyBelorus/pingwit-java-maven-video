package com.pingwit.part_34.semaphore;

public class SemaphoreTheory {
    public static void main(String[] args) {
        /*
        Класс Semaphore из пакета java.util.concurrent представляет собой синхронизирующий механизм,
        который позволяет регулировать доступ к общему ресурсу или ограничивать количество потоков,
        которым разрешено выполнять определенную операцию одновременно.
        Он работает на основе счетчика и предоставляет методы для получения и освобождения разрешений.
         */

        /*
        Основные аспекты и функции класса Semaphore:

        - Счетчик разрешений: Semaphore содержит счетчик, который указывает количество доступных разрешений.
        При создании объекта Semaphore вы указываете начальное количество разрешений.

        - Методы acquire(), tryAcquire и release():
            Метод acquire() используется потоком для получения разрешения из семафора.
            Если счетчик разрешений равен нулю, вызов метода acquire() блокирует поток до тех пор,
            пока не будет освобождено хотя бы одно разрешение. Это позволяет контролировать доступ к общим ресурсам и избегать гонок данных.

            Метод release() используется потоком для освобождения разрешения в семафоре.
            Это увеличивает счетчик разрешений.

            Метод tryAcquire() позволяет выполнить попытку захвата разрешения, и если оно доступно, метод вернет true, иначе - false.

        - Повторное использование: Разрешения могут быть использованы многократно.
          Когда поток завершает работу с общим ресурсом, он освобождает разрешение, которое может быть использовано другими потоками.
         */
    }
}
