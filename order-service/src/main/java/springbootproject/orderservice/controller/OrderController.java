package springbootproject.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootproject.basedomainservice.dto.Order;
import springbootproject.basedomainservice.dto.OrderEvent;
import springbootproject.orderservice.service.OrderProducer;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;
    @PostMapping("/orders")
    public String placementOrder(@RequestBody Order order){
   order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("ORDER IS ON PENDING STATE");
        orderEvent.setOrder(order);
        orderProducer.senMessage(orderEvent);
        return "ORDER HAS SUCCESSFULLY PLACED !";

    }
}
