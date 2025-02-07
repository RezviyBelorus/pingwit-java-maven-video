package com.pingwit.part_34.cyclic_barrier;

public class CyclicBarrierTheory {
    public static void main(String[] args) {
        /*
        CyclicBarrier позволяет группе потоков дождаться друг друга в определенной точке выполнения,
        прежде чем они продолжат свое выполнение дальше.
        Он похож на CountDownLatch, но с той разницей, что он может быть переиспользован после каждого раза достижения барьера.
        Поэтому он называется "циклическим" барьером.

        Как только все потоки прибыли, выполняется опционное действие (или не выполняется, если барьер был инициализирован без него)
         */

        /*
        Основные характеристики и особенности CyclicBarrier:

        - Синхронизация группы потоков: CyclicBarrier позволяет группе потоков дождаться друг друга в определенной точке выполнения.
          Когда все потоки достигают барьера, он отпускается, и все потоки могут продолжить выполнение.

        - Переиспользование: После того как барьер был разблокирован, он может быть переиспользован для синхронизации потоков
          в следующем цикле выполнения. Это позволяет использовать CyclicBarrier многократно.

        - Инициализация: CyclicBarrier инициализируется с указанием количества потоков,
          которые должны достичь барьера, прежде чем он будет разблокирован.

        - Методы await() и reset():
            Метод await(): Каждый поток вызывает метод await() при достижении барьера.
            Этот вызов блокирует поток до тех пор, пока все остальные потоки не достигнут барьера.

            Метод reset(): Позволяет сбросить барьер, если он уже был достигнут.
         */
    }
}
