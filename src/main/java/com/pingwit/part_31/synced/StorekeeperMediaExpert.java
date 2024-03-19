package com.pingwit.part_31.synced;

import java.util.List;

class StorekeeperMediaExpert implements Runnable {
    private final MediaExpert mediaMarket;
    private final List<AgdMediaExpert> electronics;

    public StorekeeperMediaExpert(MediaExpert mediaMarket, List<AgdMediaExpert> electronics) {
        this.mediaMarket = mediaMarket;
        this.electronics = electronics;
    }

    @Override
    public void run() {
        for (AgdMediaExpert electronic : electronics) {
            for (int i = 0; i < electronic.quantity(); i++) {
                mediaMarket.add(electronic);
            }
        }
    }
}
