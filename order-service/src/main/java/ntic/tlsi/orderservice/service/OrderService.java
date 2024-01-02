package ntic.tlsi.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ntic.tlsi.orderservice.common.Payment;
import ntic.tlsi.orderservice.common.TransactionRequest;
import ntic.tlsi.orderservice.common.TransactionResponse;
import ntic.tlsi.orderservice.entities.Order;
import ntic.tlsi.orderservice.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

    @Autowired
    private OrderRepository repository ;
    @Autowired
    @Lazy
    private RestTemplate template;
    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;
    private Logger log = LoggerFactory.getLogger(OrderService.class);

    public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException {
        String msg = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        System.out.println(payment.getAmount());
        // Rest Call
        log.info("OderService request : {}", new ObjectMapper().writeValueAsString(request));
        Payment paymentResponse = template.postForObject
                (ENDPOINT_URL,
                        payment ,
                        Payment.class);

        log.info(" Payment-service response to OderService rest call : {}", new ObjectMapper().writeValueAsString(paymentResponse));

         msg = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order place":"there is a failure in payment api , order added to cart ";

         repository.save(order);
         return new TransactionResponse(order , paymentResponse.getAmount(),paymentResponse.getTransactionId(),msg) ;
    }

}
