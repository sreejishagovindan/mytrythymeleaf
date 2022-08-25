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
    public String displayAllEvents(Model model){
       // List<String> events =new ArrayList<>();
        //events.add("code with pride");
        //events.add("Strange Loop");
        //events.add("Apple WWDC");
        //events.add("Spring One platform");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }
    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        model.addAttribute("title","Create Event");
       model.addAttribute("event",new Event());
       model.addAttribute("eventCategories",eventCategoryRepository.findAll());
       System.out.println("Size of Cat = " + eventCategoryRepository.findAll());
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
