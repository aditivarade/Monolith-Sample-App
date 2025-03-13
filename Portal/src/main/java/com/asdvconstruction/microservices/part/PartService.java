package com.asdvconstruction.microservices.part; 
import jakarta.ws.rs.GET; 
import jakarta.ws.rs.Path; 
import jakarta.ws.rs.Produces; 
import jakarta.ws.rs.core.MediaType; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
@Path("/parts") 
public class PartService { 
    private static final Logger LOGGER = Logger.getLogger(PartService.class.getName()); 
    @GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public String getParts() { 
        try { 
            LOGGER.log(Level.INFO, "Fetching list of parts"); 
            // Placeholder for actual logic 
            return "[]"; 
        } catch (Exception e) { 
            LOGGER.log(Level.SEVERE, "Error fetching parts", e); 
            return "{\"error\": \"Unable to fetch parts\"}"; 
        } 
    } 
} 