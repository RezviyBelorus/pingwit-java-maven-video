package com.pingwit.part_31.synced.block;

import java.util.List;

record RtvEuroAgd(List<AgdRtvEuroAgd> electronics) {
    synchronized void add(AgdRtvEuroAgd item) {
        this.electronics().add(item);
    }

    void addBatch(List<AgdRtvEuroAgd> items) {
        synchronized (this) {
            this.electronics().addAll(items);
        }

        /*
        some code...
         */
    }

    void addBatchSyncAnotherObjectDoNotUse(List<AgdRtvEuroAgd> items) {
        synchronized (RtvEuroAgd.class) {
            this.electronics().addAll(items);
        }

        /*
        some code...
         */
    }

}
