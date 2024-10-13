package net.ensah.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ensah.inventoryservice.enums.OrderStatus;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class OrderEntity {
    private Long id;
    private String productCode;
    private int quantity;
    private OrderStatus status;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", quantity=" + quantity +
                ", status=" + status +
                '}';
    }
}
