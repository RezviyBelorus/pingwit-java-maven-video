package com.pingwit.part_43;

public class IceCreamService {
    private final IceCreamRepository iceCreamRepository;
    private final IceCreamValidationService iceCreamValidationService;

    public IceCreamService(IceCreamRepository iceCreamRepository, IceCreamValidationService iceCreamValidationService) {
        this.iceCreamRepository = iceCreamRepository;
        this.iceCreamValidationService = iceCreamValidationService;
    }

    public void save(String iceCream) {
       iceCreamRepository.save(iceCream);
    }
}
