package ntic.tlsi.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ntic.tlsi.orderservice.entities.Order;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionRequest {
    private Order order;
    private Payment payment;
}
