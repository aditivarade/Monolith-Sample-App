package com.asdvconstruction.portal.controller; 
import com.asdvconstruction.portal.model.Part; 
import com.asdvconstruction.portal.service.PartDAO; 
import com.asdvconstruction.portal.util.Utilities; 
import jakarta.faces.application.FacesMessage; 
import jakarta.faces.component.UIComponent; 
import jakarta.faces.context.FacesContext; 
import jakarta.faces.validator.ValidatorException; 
import jakarta.faces.view.ViewScoped; 
import jakarta.inject.Inject; 
import jakarta.inject.Named; 
import org.primefaces.PrimeFaces; 
import org.primefaces.component.inputnumber.InputNumber; 
import org.primefaces.event.RowEditEvent; 
import java.io.Serializable; 
import java.sql.SQLException; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
/** 
 * The {@code PartBean} is a CDI managed bean responsible for handling user operations related to the part.xhtml page 
 * and the part table. 
 * 
 * This class is part of the Part Service in the microservices architecture, responsible for managing construction parts 
 * and inventory. It interacts with the Project Service for part allocation. 
 * 
 * Responsibilities: 
 * - Manage CRUD operations for parts. 
 * - Validate part data. 
 * - Handle user interactions on the part.xhtml page. 
 * 
 * Data Ownership: 
 * - Owns part details and inventory levels. 
 * 
 * Interactions: 
 * - Interfaces with Project Service for part allocation. 
 * 
 * Logging and Error Handling: 
 * - Logs all operations and errors for better traceability. 
 * - Handles SQL exceptions and validation errors gracefully. 
 */ 
@Named(value = "partBean") 
@ViewScoped 
public class PartBean implements Serializable { 
    @Inject 
    SPJBean spjBean; 
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName()); 
    private final PartDAO PART_DAO; 
    private Part createPart; 
    private Part readPart; 
    private List<Part> parts; 
    private Part updatePart; 
    public PartBean() { 
        PART_DAO = new PartDAO(); 
        createPart = new Part(); 
        readPart = new Part(); 
        try { 
            parts = PART_DAO.readAll(); 
        } catch (SQLException e) { 
            Utilities.addMessage(FacesMessage.SEVERITY_FATAL, "Error retrieving data.", null); 
            LOGGER.log(Level.SEVERE, e.getMessage(), e); 
        } 
        updatePart = new Part(); 
    } 
    public Part getCreatePart() { 
        return createPart; 
    } 
    public void setCreatePart(Part createPart) { 
        this.createPart = createPart; 
    } 
    public Part getReadPart() { 
        return readPart; 
    } 
    public void setReadPart(Part readPart) { 
        this.readPart = readPart; 
    } 
    public List<Part> getParts() { 
        return parts; 
    } 
    @SuppressWarnings("unused") 
    public void validateID(FacesContext facesContext, UIComponent uiComponent, Object o) { 
        if (o == null) 
            throw new ValidatorException( 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "The ID field is required.", null)); 
        for (Part part : parts) 
            if (((InputNumber) uiComponent).getValue() == part.getId()) 
                updatePart = new Part(part); 
    } 
    @SuppressWarnings("unused") 
    public void validateRequired(FacesContext facesContext, UIComponent uiComponent, Object o) { 
        if (o == null) 
            throw new ValidatorException( 
                    new FacesMessage( 
                            FacesMessage.SEVERITY_ERROR, "All fields are required", null)); 
        else if (o instanceof String && ((String) o).isEmpty()) 
            throw new ValidatorException( 
                    new FacesMessage( 
                            FacesMessage.SEVERITY_ERROR, "All fields are required", null)); 
    } 
    public void create() { 
        try { 
            PART_DAO.create(createPart); 
            parts = PART_DAO.readAll(); 
        } catch (SQLException e) { 
            Utilities.addMessage(FacesMessage.SEVERITY_ERROR, "Part not added.", 
                    "An error occurred while attempted to insert the part."); 
            LOGGER.log(Level.SEVERE, e.getMessage(), e); 
        } 
        createPart = new Part(); 
        PrimeFaces.current().executeScript("PF('create').hide()"); 
    } 
    public void read() { 
        if (readPart.getId() == null) { 
            Utilities.addMessage(FacesMessage.SEVERITY_ERROR, "Invalid search parameter.", null); 
            return; 
        } 
        try { 
            readPart = PART_DAO.read(readPart.getId()); 
            if (readPart != null) { 
                showReadDialog(); 
                return; 
            } 
        } catch (SQLException e) { 
            Utilities.addMessage(FacesMessage.SEVERITY_ERROR, "Search not completed.", 
                    "An error occurred while attempted to locate the part."); 
            LOGGER.log(Level.SEVERE, e.getMessage(), e); 
            readPart = new Part(); 
            return; 
        } 
        Utilities.addMessage(FacesMessage.SEVERITY_INFO, "Part not found.", 
                "No part exists with that ID."); 
        readPart = new Part(); 
    } 
    private void showReadDialog() { 
        PrimeFaces.current().ajax().update(Utilities.findComponent("search")); 
        PrimeFaces.current().executeScript("PF('search').show()"); 
        readPart.setId(null); 
    } 
    public void update(int i) { 
        Part part = parts.get(i); 
        try { 
            PART_DAO.update(updatePart.getId(), part); 
            parts = PART_DAO.readAll(); 
        } catch (SQLException e) { 
            Utilities.addMessage(FacesMessage.SEVERITY_ERROR, "Part not updated.", 
                    "An error occurred while attempted to update the part."); 
            LOGGER.log(Level.SEVERE, e.getMessage(), e); 
        } 
        updatePart = new Part(); 
    } 
    @SuppressWarnings("unused") 
    public void updateCancel(RowEditEvent<Object> rowEditEvent) { 
        Utilities.addMessage(FacesMessage.SEVERITY_WARN, "Update canceled.", null); 
    } 
    public void delete() { 
        try { 
            PART_DAO.delete(updatePart); 
            parts = PART_DAO.readAll(); 
            Utilities.addMessage(FacesMessage.SEVERITY_INFO, "Part deleted.", null); 
        } catch (SQLException e) { 
            Utilities.addMessage(FacesMessage.SEVERITY_ERROR, "Part not deleted.", 
                    "An error occurred while attempting to delete the part"); 
            LOGGER.log(Level.SEVERE, e.getMessage(), e); 
        } 
        updatePart = new Part(); 
    } 
    public void showDeleteDialog(Part part) { 
        updatePart = part; 
        PrimeFaces.current().ajax().update(Utilities.findComponent("confirm")); 
        PrimeFaces.current().executeScript("PF('delete').show()"); 
    } 
    public String deleteConfirm() { 
        int spjRows = 0; 
        if (updatePart.getId() != null) { 
            try { 
                spjRows = spjBean.getSPJ_DAO().partCount(updatePart.getId()); 
            } catch (SQLException e) { 
                LOGGER.log(Level.SEVERE, e.getMessage(), e); 
            } 
        } 
        String part = "ID = <b>" + updatePart.getId() + "</b>&nbsp;&nbsp;|&nbsp;&nbsp;Name = <b>" + 
                updatePart.getName() + "</b>"; 
        String warning = "<div class='confirm-warning'><span class='confirm-warning-text'><b>Warning: </b>" + spjRows + 
                " records in SPJ will be removed if you continue.</span></div>"; 
        String confirm = "<div class='confirm-text'>Are you sure you would like to delete the part?</div>"; 
        if (spjRows == 0) 
            return part + confirm; 
        return part + confirm + warning; 
    } 
    public void deleteCancel() { 
        updatePart = new Part(); 
    } 
}