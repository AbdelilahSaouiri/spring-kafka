package net.ensah.inventoryservice.service;

import lombok.extern.slf4j.Slf4j;
import net.ensah.inventoryservice.entity.ProductIneventory;
import net.ensah.inventoryservice.model.OrderEntity;
import net.ensah.inventoryservice.repository.ProductInvRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
@Slf4j
public class InventoryService {

    private final ProductInvRepository productInvRepository;

    public InventoryService(ProductInvRepository productInvRepository) {
        this.productInvRepository = productInvRepository;
    }

    @Bean
    public Consumer<OrderEntity> OrderEntityConsumer() {
        return (input) -> {
            try {
                ProductIneventory productIneventory = ProductIneventory.builder()
                                .productCode(input.getProductCode())
                                        .quantityAvailable(input.getQuantity())
                                                .build();
                log.info("received order");
                ProductIneventory saved = productInvRepository.save(productIneventory);
            } catch (Exception e) {
                System.out.println("Error in handling message: " + e.getMessage());
            }
        };
    }


    public List<ProductIneventory> getAll() {
        return productInvRepository.findAll();
    }
}
