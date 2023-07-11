package springbootproject.orderservice.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import springbootproject.basedomainservice.dto.OrderEvent;

@Service
public class OrderProducer {

    private NewTopic topic;
private final  KafkaTemplate<String, OrderEvent> kafkaTemplate;
private Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
    public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }
    public void  senMessage(OrderEvent orderEvent){
        Message<OrderEvent> message = MessageBuilder.withPayload(orderEvent)
                        .setHeader(KafkaHeaders.TOPIC,topic.name())
                                .build();
        kafkaTemplate.send(message);

        LOGGER.info(String.format("order event ->%s",orderEvent.toString()));
    }

}
