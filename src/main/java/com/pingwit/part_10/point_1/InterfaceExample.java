package com.pingwit.part_10.point_1;

@SuppressWarnings("SpellCheckingInspection")
public class InterfaceExample {
    public static void main(String[] args) {
        /*
        Это слово вы наверняка уже не раз слышали. Например, интерфейсы есть у большинства компьютерных программ и игр.
        В широком смысле интерфейс — некий «пульт», который связывает две взаимодействующие друг с другом стороны.

        Простой пример интерфейса из повседневной жизни - автомобиль.
        Вы сидите за рулем, слушаете музыку, переключаете передачи, нажимаете газ и тормоз - все это для вас интерфейс.
        Вы не задумываетесь как работает руль, что происходит внутри автомобиля для переключения передачи или
        как обработать радио частоты чтобы у вас играла музыка.
         */

        Car audi = new Audi();
        Car tesla = new Tesla();

        Car[] cars = new Car[10];
        cars[0] = audi;
        cars[1] = tesla;

        System.out.println(audi.getProducer());
        audi.openDoor();
        System.out.println(tesla.getProducer());
        tesla.openDoor();
    }
}
