package org.launchcode.mytrythymeleaf.controllers;

import org.launchcode.mytrythymeleaf.data.EventData;
import org.launchcode.mytrythymeleaf.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    //private static List<Event> events =new ArrayList<>();
    @GetMapping
    public String displayAllEvents(Model model){
       // List<String> events =new ArrayList<>();
        //events.add("code with pride");
        //events.add("Strange Loop");
        //events.add("Apple WWDC");
        //events.add("Spring One platform");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }
    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent /*@RequestParam String eventName,@RequestParam String eventDescription*/){
        EventData.add(newEvent);
        return "redirect:"
                ;
    }
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "/events/delete";
    }
    @PostMapping("delete")
    public String preocessDeleteEventForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {


        for (int id : eventIds) {
            EventData.remove(id);
        }
    }
       return "redirect:";
    }
}
