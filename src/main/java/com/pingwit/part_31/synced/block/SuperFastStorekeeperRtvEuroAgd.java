package com.pingwit.part_31.synced.block;

import java.util.Collections;
import java.util.List;

class SuperFastStorekeeperRtvEuroAgd implements Runnable {
    private final RtvEuroAgd rtvEuroAgd;
    private final List<AgdRtvEuroAgd> electronics;

    public SuperFastStorekeeperRtvEuroAgd(RtvEuroAgd rtvEuroAgd, List<AgdRtvEuroAgd> electronics) {
        this.rtvEuroAgd = rtvEuroAgd;
        this.electronics = electronics;
    }

    @Override
    public void run() {
        for (AgdRtvEuroAgd electronic : electronics) {
            List<AgdRtvEuroAgd> unboxedElectronic = Collections.nCopies(electronic.quantity(), electronic);
            rtvEuroAgd.addBatch(unboxedElectronic);
        }
    }
}
