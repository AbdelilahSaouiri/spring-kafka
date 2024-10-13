package net.ensah.inventoryservice.service;

import lombok.extern.slf4j.Slf4j;
import net.ensah.inventoryservice.entity.ProductIneventory;
import net.ensah.inventoryservice.model.OrderEntity;
import net.ensah.inventoryservice.repository.ProductInvRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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
        System.out.println("arrived ***********");
        return (input) -> {
            try {
                System.out.println("*****************");
                log.info("received order");
                System.out.println("Received message: " +input.toString());
                log.info("input {}", input);
                System.out.println("*****************");
            } catch (Exception e) {
                System.out.println("Error in handling message: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }

}
