package ntic.tlsi.orderservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import ntic.tlsi.orderservice.common.Payment;
import ntic.tlsi.orderservice.common.TransactionRequest;
import ntic.tlsi.orderservice.common.TransactionResponse;
import ntic.tlsi.orderservice.entities.Order;
import ntic.tlsi.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService ;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) throws JsonProcessingException {

        return orderService.saveOrder(request);
    }
}
