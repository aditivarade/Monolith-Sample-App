package com.asdvconstruction.microservices.part; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.kafka.core.KafkaTemplate; 
import org.springframework.stereotype.Service; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
@Service 
public class PartProducer { 
    private static final Logger logger = LoggerFactory.getLogger(PartProducer.class); 
    @Autowired 
    private KafkaTemplate<String, Object> kafkaTemplate; 
    public void sendMessage(String message) { 
        try { 
            kafkaTemplate.send("asdv_topic", message); 
            logger.info("Message sent successfully: {}", message); 
        } catch (Exception e) { 
            logger.error("Error sending message: {}", e.getMessage(), e); 
        } 
    } 
} 