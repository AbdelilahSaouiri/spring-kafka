package net.ensah.orderservice.service;

import lombok.extern.slf4j.Slf4j;
import net.ensah.orderservice.entity.OrderEntity;
import net.ensah.orderservice.enums.OrderStatus;
import net.ensah.orderservice.repository.OrderRepository;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
@Slf4j
public class OrderServiceImpl {

    private final OrderRepository orderRepository;
    private final StreamBridge streamBridge;

    public OrderServiceImpl(OrderRepository orderRepository, StreamBridge streamBridge) {
        this.orderRepository = orderRepository;
        this.streamBridge = streamBridge;
    }

    public OrderEntity addNewOrder(OrderEntity order) {
        OrderEntity orderEntity =OrderEntity.builder()
                .status(OrderStatus.NEW)
                .productCode(order.getProductCode())
                .quantity(order.getQuantity())
                .build();
        OrderEntity saved = orderRepository.save(orderEntity);
          log.info("save a new Order");
        String topic = "T1";
        streamBridge.send(topic,saved);
        return saved;
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

}
