package com.pingwit.part_13.point_3;

@SuppressWarnings("SpellCheckingInspection")
public class TypesOfReferences {
    public static void main(String[] args) {
        /*
        StrongReference - все что мы создаем через new

        WeakReference - скорее всего, не сохранится после следующего процесса сборки мусора.
        Слабая ссылка создается следующим образом:
        WeakReference<StringBuilder> reference = new WeakReference<>(new StringBuilder());

        SoftReference - эти типы ссылок используются для более чувствительных к памяти сценариев,
        поскольку они будут собираться сборщиком мусора только тогда, когда вашему приложению не хватает памяти.
        SoftReference<StringBuilder> reference = new SoftReference<>(new StringBuilder());

        PhantomReference - используется для планирования посмертных действий по очистке,
        поскольку мы точно знаем, что объекты больше не живы. Используется только с очередью ссылок,
        поскольку .get() метод таких ссылок всегда будет возвращаться null.
        Эти типы ссылок считаются предпочтительными для финализаторов.
         */
    }
}
