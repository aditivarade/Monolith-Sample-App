package com.asdvconstruction.microservices.user; 
import jakarta.ws.rs.GET; 
import jakarta.ws.rs.Path; 
import jakarta.ws.rs.Produces; 
import jakarta.ws.rs.core.MediaType; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
@Path("/users") 
public class UserService { 
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName()); 
    @GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public String getUsers() { 
        LOGGER.log(Level.INFO, "Fetching list of users"); 
        try { 
            // Placeholder for actual logic to fetch users 
            return "[]"; 
        } catch (Exception e) { 
            LOGGER.log(Level.SEVERE, "Error fetching users", e); 
            return "{\"error\": \"Unable to fetch users\"}"; 
        } 
    } 
}