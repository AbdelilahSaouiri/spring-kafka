package net.ensah.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;
import net.ensah.orderservice.enums.OrderStatus;

@Entity
@AllArgsConstructor  @NoArgsConstructor @Builder @Getter @Setter
public class OrderEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productCode;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
