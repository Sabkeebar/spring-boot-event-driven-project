package springbootproject.emailservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import springbootproject.basedomainservice.dto.OrderEvent;
@Service
public class EmailService {





    private Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void receiveMessage(@Payload OrderEvent orderEvent){
        LOGGER.info(String.format("event has received in email service %s",orderEvent.toString()));
        System.out.println("..."+orderEvent.getOrder());





    }

}
