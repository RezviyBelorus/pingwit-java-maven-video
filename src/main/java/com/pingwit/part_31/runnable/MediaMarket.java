package com.pingwit.part_31.runnable;

import java.util.List;

record MediaMarket(List<Agd> electronics) {

    void add(Agd item) {
        this.electronics().add(item);
    }
}
