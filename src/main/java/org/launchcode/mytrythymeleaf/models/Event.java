package org.launchcode.mytrythymeleaf.models;

import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
@Entity
public class Event extends AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    //private static int nextId=1;
    @Size(min=3,max=50 ,message="name must be between 3 and 50 characters")
    @NotBlank(message="name cannot be blank")
    private String name;
    @Size(max=500,message="description too long")

    private String description;


    @NotBlank(message="Email cannot be blank")
    @Email(message="invalid email!! try again")
    private String contactEmail;
    private EventType type;
    public Event(String name, String description, String contactEmail, EventType type){
        this.name=name;
        this.description=description;
        this.contactEmail=contactEmail;
        this.type=type;

    }

   public Event(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }


}
