package org.launchcode.mytrythymeleaf.controllers;

import org.launchcode.mytrythymeleaf.data.EventCategoryRepository;
import org.launchcode.mytrythymeleaf.data.EventRepository;
import org.launchcode.mytrythymeleaf.models.Event;
import org.launchcode.mytrythymeleaf.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventCategoryRepository eventCategoryRepository;
    //findAll,save,findById
    //private static List<Event> events =new ArrayList<>();
    @GetMapping
    public String displayAllEvents(@RequestParam(required=false) Integer categoryId, Model model ){
    if(categoryId==null){

        model.addAttribute("title","Create Event");
        model.addAttribute("events", eventRepository.findAll());

    }
    else{
        Optional<EventCategory> result=eventCategoryRepository.findById(categoryId);
        if(result.isEmpty()){
            model.addAttribute("title","Invalid category ID"+categoryId);
        }else{
           EventCategory category=result.get();
           model.addAttribute("title","Events in category" +category.getName());
           model.addAttribute("events",category.getEvents());
        }

    }
        return "events/index";
    }
    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        model.addAttribute("title","Create Event");
       model.addAttribute("event",new Event());
       model.addAttribute("eventCategories",eventCategoryRepository.findAll());

        return "events/create";
    }
    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors,Model model ){
        if(errors.hasErrors()){
            model.addAttribute("title","Create Event");
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:";

    }
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",eventRepository.findAll());
        return "/events/delete";
    }
    @PostMapping("delete")
    public String preocessDeleteEventForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {


        for (int id : eventIds) {
            eventRepository.deleteById(id);
        }
    }
       return "redirect:";
    }
}
