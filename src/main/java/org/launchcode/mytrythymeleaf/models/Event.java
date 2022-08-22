package org.launchcode.mytrythymeleaf.models;

import org.springframework.boot.convert.DataSizeUnit;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextId=1;
    @Size(min=3,max=50 ,message="name must be between 3 and 50 characters")
    @NotBlank(message="name cannot be blank")
    private String name;
    @Size(max=500,message="description too long")

    private String description;

    @NotBlank(message="Email cannot be blank")
    @Email(message="invalid email!! try again")
    private String contactEmail;
    public Event(String name, String description, String contactEmail){
        this.name=name;
        this.description=description;
        this.contactEmail=contactEmail;
        this.id=nextId;
        nextId++;
    }

   public Event(){

   }

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

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
