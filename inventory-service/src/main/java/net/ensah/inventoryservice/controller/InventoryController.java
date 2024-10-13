package net.ensah.inventoryservice.controller;

import net.ensah.inventoryservice.model.OrderEntity;
import net.ensah.inventoryservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
@RequestMapping("/api/v1/inv")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<?> getMessage(){
        Consumer<?> orderEntityConsumer = inventoryService.OrderEntityConsumer();
        return ResponseEntity.ok(orderEntityConsumer);
    }
}
