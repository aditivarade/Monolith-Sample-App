package com.asdvconstruction.portal.model; 
/** 
 * User model representing a user in the system. 
 * Handles user-related data such as username, password, and role. 
 * This class is part of the User Service in the microservices architecture. 
 * 
 * Responsibilities: 
 * - Manage user authentication and authorization data. 
 * - Provide access to user credentials and profiles. 
 * 
 * Interactions: 
 * - Interfaces with other services for access control. 
 * 
 * Error Handling: 
 * - Ensure proper validation and error handling for user data. 
 * 
 * Logging: 
 * - Log significant actions and errors for monitoring and debugging. 
 * 
 * Author: Michael C. Herrera 
 */ 
@SuppressWarnings("unused") 
public class User { 
    private String username; 
    private String password; 
    private String role; 
    /** 
     * Construct a new User. 
     * 
     * @param username username of User 
     * @param password password of User 
     * @param role     role of User 
     */ 
    public User(String username, String password, String role) { 
        if (username == null || password == null || role == null) { 
            throw new IllegalArgumentException("Username, password, and role must not be null"); 
        } 
        this.username = username; 
        this.password = password; 
        this.role = role; 
        System.out.println("User created: " + username); 
    } 
    /** 
     * Get the value of username. 
     * 
     * @return the value of username 
     */ 
    public String getUsername() { 
        return username; 
    } 
    /** 
     * Set the value of username. 
     * 
     * @param username new value of username 
     */ 
    public void setUsername(String username) { 
        if (username == null) { 
            throw new IllegalArgumentException("Username must not be null"); 
        } 
        this.username = username; 
        System.out.println("Username updated to: " + username); 
    } 
    /** 
     * Get the value of password. 
     * 
     * @return the value of password 
     */ 
    public String getPassword() { 
        return password; 
    } 
    /** 
     * Set the value of password. 
     * 
     * @param password new value of password 
     */ 
    public void setPassword(String password) { 
        if (password == null) { 
            throw new IllegalArgumentException("Password must not be null"); 
        } 
        this.password = password; 
        System.out.println("Password updated for user: " + username); 
    } 
    /** 
     * Get the value of role. 
     * 
     * @return the value of role 
     */ 
    public String getRole() { 
        return role; 
    } 
    /** 
     * Set the value of role. 
     * 
     * @param role new value of role 
     */ 
    public void setRole(String role) { 
        if (role == null) { 
            throw new IllegalArgumentException("Role must not be null"); 
        } 
        this.role = role; 
        System.out.println("Role updated to: " + role + " for user: " + username); 
    } 
}