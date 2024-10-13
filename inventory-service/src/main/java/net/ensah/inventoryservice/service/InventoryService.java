package net.ensah.inventoryservice.service;

import net.ensah.inventoryservice.repository.ProductInvRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final ProductInvRepository productInvRepository;

    public InventoryService(ProductInvRepository productInvRepository) {
        this.productInvRepository = productInvRepository;
    }
}
