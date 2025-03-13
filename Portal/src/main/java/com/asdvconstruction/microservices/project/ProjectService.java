package com.asdvconstruction.microservices.project; 
import jakarta.ws.rs.GET; 
import jakarta.ws.rs.Path; 
import jakarta.ws.rs.Produces; 
import jakarta.ws.rs.core.MediaType; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
@Path("/projects") 
public class ProjectService { 
    private static final Logger LOGGER = Logger.getLogger(ProjectService.class.getName()); 
    @GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public String getProjects() { 
        try { 
            LOGGER.info("Fetching list of projects"); 
            // Placeholder for actual logic 
            return "[]"; 
        } catch (Exception e) { 
            LOGGER.log(Level.SEVERE, "Error fetching projects", e); 
            return "{\"error\": \"Unable to fetch projects\"}"; 
        } 
    } 
}