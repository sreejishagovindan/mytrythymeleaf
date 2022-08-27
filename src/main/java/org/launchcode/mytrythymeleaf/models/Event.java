package org.launchcode.mytrythymeleaf.models;

import org.hibernate.engine.spi.CascadingActions;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.cglib.core.EmitUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Event extends AbstractEntity {

    //private static int nextId=1;
    @Size(min=3,max=50 ,message="name must be between 3 and 50 characters")
    @NotBlank(message="name cannot be blank")
    private String name;
    @OneToOne(cascade= CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToOne
    @NotNull(message="Category is required")
    private EventCategory eventCategory;
    @ManyToMany
    private final List<Tag> tags=new ArrayList<>();
    public Event(String name, EventCategory eventCategory){
        this.name=name;

        this.eventCategory=eventCategory;

    }

   public Event(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }
    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Tag> getTag() {
        return tags;
    }
    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return name;
    }


}
