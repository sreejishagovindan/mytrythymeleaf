package org.launchcode.mytrythymeleaf.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity {
    @Size(max=500,message="description too long")
    private String description;


    @NotBlank(message="Email cannot be blank")
    @Email(message="invalid email!! try again")
    private String contactEmail;

    public EventDetails(String description, String contactEmail) {
        this.description = description;
        this.contactEmail = contactEmail;
    }
    public EventDetails(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
