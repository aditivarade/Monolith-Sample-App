package com.asdvconstruction.microservices.part; 
import org.springframework.kafka.annotation.KafkaListener; 
import org.springframework.stereotype.Service; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
@Service 
public class PartConsumer { 
    private static final Logger logger = LoggerFactory.getLogger(PartConsumer.class); 
    @KafkaListener(topics = "asdv_topic", groupId = "group_id") 
    public void consume(String message) { 
        try { 
            logger.info("Consumed message: {}", message); 
            // Process the message here 
        } catch (Exception e) { 
            logger.error("Error while consuming message: {}", message, e); 
        } 
    } 
}