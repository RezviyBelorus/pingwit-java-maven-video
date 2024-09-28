package com.pingwit.part_43;

public class IceCreamApp {
    public static void main(String[] args) {
        IceCreamRepository iceCreamRepository = new IceCreamRepository();
        IceCreamValidationService iceCreamValidationService = new IceCreamValidationService();
        IceCreamService iceCreamService = new IceCreamService(iceCreamRepository, iceCreamValidationService);

        IceCreamController iceCreamController = new IceCreamController(iceCreamService);

        iceCreamController.save("new ice cream");

    }
}
