package com.pingwit.part_31.synced.block;

import java.util.List;

class StorekeeperRtvEuroAgd implements Runnable {
    private final RtvEuroAgd rtvEuroAgd;
    private final List<AgdRtvEuroAgd> electronics;

    public StorekeeperRtvEuroAgd(RtvEuroAgd rtvEuroAgd, List<AgdRtvEuroAgd> electronics) {
        this.rtvEuroAgd = rtvEuroAgd;
        this.electronics = electronics;
    }

    @Override
    public void run() {
        for (AgdRtvEuroAgd electronic : electronics) {
            for (int i = 0; i < electronic.quantity(); i++) {
                rtvEuroAgd.add(electronic);
            }
        }
    }
}
