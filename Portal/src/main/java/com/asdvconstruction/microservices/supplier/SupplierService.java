package com.asdvconstruction.microservices.supplier; 
import jakarta.ws.rs.GET; 
import jakarta.ws.rs.Path; 
import jakarta.ws.rs.Produces; 
import jakarta.ws.rs.core.MediaType; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
@Path("/suppliers") 
public class SupplierService { 
    private static final Logger LOGGER = Logger.getLogger(SupplierService.class.getName()); 
    @GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public String getSuppliers() { 
        LOGGER.log(Level.INFO, "Executing getSuppliers method"); 
        try { 
            // Placeholder for actual logic 
            return "[]"; 
        } catch (Exception e) { 
            LOGGER.log(Level.SEVERE, "Error occurred in getSuppliers method", e); 
            return "{\"error\": \"An error occurred while retrieving suppliers.\"}"; 
        } 
    } 
}