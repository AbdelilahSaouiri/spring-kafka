package net.ensah.orderservice.controller;

import net.ensah.orderservice.entity.OrderEntity;
import net.ensah.orderservice.service.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

   private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> newOrder(@RequestBody OrderEntity order) {
        OrderEntity ord = orderService.addNewOrder(order);
        return ResponseEntity.ok(ord);
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
