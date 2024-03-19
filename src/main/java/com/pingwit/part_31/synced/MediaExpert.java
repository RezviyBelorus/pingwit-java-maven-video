package com.pingwit.part_31.synced;

import java.util.List;

record MediaExpert(List<AgdMediaExpert> electronics) {
    synchronized void add(AgdMediaExpert item) {
        this.electronics().add(item);
    }

}
