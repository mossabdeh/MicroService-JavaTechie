package ntic.tlsi.orderservice.repositories;

import ntic.tlsi.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order , Integer> {
}
