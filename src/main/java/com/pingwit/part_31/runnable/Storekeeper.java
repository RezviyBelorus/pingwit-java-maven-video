package com.pingwit.part_31.runnable;

import java.util.List;

class Storekeeper implements Runnable {
    private final MediaMarket mediaMarket;
    private final List<Agd> electronics;

    public Storekeeper(MediaMarket mediaMarket, List<Agd> electronics) {
        this.mediaMarket = mediaMarket;
        this.electronics = electronics;
    }

    @Override
    public void run() {
        for (Agd electronic : electronics) {
            for (int i = 0; i < electronic.quantity(); i++) {
                mediaMarket.add(electronic);
            }
        }
    }
}
