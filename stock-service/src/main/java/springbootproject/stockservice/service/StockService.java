package springbootproject.stockservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.stereotype.Service;
import springbootproject.basedomainservice.dto.OrderEvent;
import springbootproject.stockservice.repositories.OrderEventRepository;


@Service

public class StockService {

    @Autowired
    private OrderEventRepository orderEventRepository;




    private Logger LOGGER = LoggerFactory.getLogger(StockService.class);
    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void receiveMessage(@Payload OrderEvent orderEvent){
        LOGGER.info(String.format("event has received in order service %s",orderEvent.toString()));
        System.out.println("..."+orderEvent.getOrder());

         orderEventRepository.save(orderEvent);



    }

}
