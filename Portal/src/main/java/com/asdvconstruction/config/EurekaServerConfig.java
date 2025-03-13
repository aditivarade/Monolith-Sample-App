package com.asdvconstruction.config; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer; 
import org.springframework.context.annotation.Configuration; 
@EnableEurekaServer 
@SpringBootApplication 
public class EurekaServerConfig { 
    // Eureka Server configuration for service discovery 
}