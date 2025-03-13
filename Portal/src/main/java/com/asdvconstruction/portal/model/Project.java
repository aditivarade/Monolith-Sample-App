package com.asdvconstruction.portal.model; 
/** 
 * A construction project. 
 * 
 * This class represents a construction project with its basic details such as id, name, and location. 
 * It provides constructors for creating a project instance and getter and setter methods for accessing 
 * and modifying the project details. 
 * 
 * The Project class is part of the Project Service, which is responsible for managing construction projects. 
 * It interacts with Part and Supplier services for resource allocation. 
 * 
 * Error handling and logging are crucial for production readiness, ensuring that any issues in project 
 * management are captured and logged appropriately. 
 * 
 * @see com.asdvconstruction.portal.service.ProjectService 
 * @see com.asdvconstruction.portal.model.Part 
 * @see com.asdvconstruction.portal.model.Supplier 
 * 
 * @author Michael C. Herrera 
 */ 
public class Project { 
    private Integer id; 
    private String name; 
    private String location; 
    /** 
     * Constructs a new Project object. 
     */ 
    public Project() { 
        // Log the creation of a new Project instance 
        System.out.println("Creating a new Project instance."); 
    } 
    /** 
     * Constructs a Project from a Project. 
     * 
     * @param project a Project 
     */ 
    public Project(Project project) { 
        this(project.id, project.name, project.location); 
        // Log the creation of a Project instance from another Project 
        System.out.println("Creating a Project instance from another Project: " + project.toString()); 
    } 
    /** 
     * Constructs a Project. 
     * 
     * @param id       project id 
     * @param name     project name 
     * @param location project location 
     */ 
    public Project(Integer id, String name, String location) { 
        this.id = id; 
        this.name = name; 
        this.location = location; 
        // Log the creation of a Project with specific details 
        System.out.println("Creating a Project with id: " + id + ", name: " + name + ", location: " + location); 
    } 
    /** 
     * Get the value of id. 
     * 
     * @return the value of id 
     */ 
    public Integer getId() { 
        return id; 
    } 
    /** 
     * Set the value of id. 
     * 
     * @param id new value of id 
     */ 
    public void setId(Integer id) { 
        this.id = id; 
        // Log the update of the project id 
        System.out.println("Project id set to: " + id); 
    } 
    /** 
     * Get the value of name. 
     * 
     * @return the value of name 
     */ 
    public String getName() { 
        return name; 
    } 
    /** 
     * Set the value of name. 
     * 
     * @param name new value of name 
     */ 
    public void setName(String name) { 
        this.name = name; 
        // Log the update of the project name 
        System.out.println("Project name set to: " + name); 
    } 
    /** 
     * Get the value of location. 
     * 
     * @return the value of location 
     */ 
    public String getLocation() { 
        return location; 
    } 
    /** 
     * Set the value of location. 
     * 
     * @param location new value of location 
     */ 
    public void setLocation(String location) { 
        this.location = location; 
        // Log the update of the project location 
        System.out.println("Project location set to: " + location); 
    } 
    /** 
     * Return a String representation of the Project. 
     * 
     * @return a String representation of the Project 
     */ 
    @Override 
    public String toString() { 
        return "Project{" + "id=" + id + ", name='" + name + '\'' + ", location='" + location + '\'' + '}'; 
    } 
}