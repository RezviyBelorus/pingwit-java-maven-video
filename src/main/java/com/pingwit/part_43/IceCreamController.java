package com.pingwit.part_43;

import org.apache.commons.lang3.ClassLoaderUtils;

public class IceCreamController {

    private final IceCreamService iceCreamService;

    public IceCreamController(IceCreamService iceCreamService) {
        this.iceCreamService = iceCreamService;
    }

    public void save(String iceCream) {
        //do some logic
        iceCreamService.save(iceCream);
    }
}
