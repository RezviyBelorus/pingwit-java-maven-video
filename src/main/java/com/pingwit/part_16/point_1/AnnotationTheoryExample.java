package com.pingwit.part_16.point_1;

@SuppressWarnings("SpellCheckingInspection")
public class AnnotationTheoryExample {
    public static void main(String[] args) {
        /*
        Аннотация - это маркер

        Каждая из них аннотаций имеет 2 главных обязательных параметра:
        1. Тип хранения (Retention);
        2. Тип объекта над которым она указывается (Target).
         */

        /*
        Retention:
        - RetentionPolicy.SOURCE. Отмеченная аннотация сохраняется только на уровне исходного кода и игнорируется компилятором.
        - RetentionPolicy.CLASS. Сохраняется компилятором во время компиляции, но игнорируется JVM.
        - RetentionPolicy.RUNTIME. Сохраняется JVM для использования во время выполнения программы.
         */

        /*
        Target:
        - ElementType.ANNOTATION_TYPE. Применяется к аннотации
        - ElementType.CONSTRUCTOR. Применяется к конструктору.
        - ElementType.FIELD. Применяется к полю или свойству.
        - ElementType.LOCAL_VARIABLE. Применяется к локальной переменной.
        - ElementType.METHOD. Применяется к методу.
        - ElementType.PARAMETER. Применяется к параметру метода.
        - ElementType.TYPE. Применяется к любому элементу класса.
         */
    }
}
