package org.fabriquita.nucleus.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.fabriquita.nucleus.models.Event;
import org.fabriquita.nucleus.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    EventService eventService;

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> list() {
        return eventService.list();
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Event get(@PathVariable(value = "id") Long id) {
        return eventService.get(id);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Event add(@RequestBody Map<String, Object> data) {
        String title = null;
        String description = null;
        Date date = null;
        String place = null;
        if (data.get("title") != null) {
            title = (String) data.get("title");
        }
        if (data.get("description") != null) {
            description = (String) data.get("description");
        }
        if (data.get("date") != null) {
            date = new Date(new Long(data.get("date").toString()));
        }
        if (data.get("place") != null) {
            place = (String) data.get("place");
        }
        return eventService.add(title,description,date,place);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Event update(@PathVariable(value = "id") Long id,
            @RequestBody Map<String, Object> data) {
        String title = null;
        String description = null;
        Date date = null;
        String place = null;
        if (data.get("title") != null) {
            title = (String) data.get("title");
        }
        if (data.get("description") != null) {
            description = (String) data.get("description");
        }
        if (data.get("date") != null) {
            date = new Date(new Long(data.get("date").toString()));
        }
        if (data.get("place") != null) {
            place = (String) data.get("place");
        }
        return eventService.update(id, title, description, date, place);
    }

    @RequiresAuthentication
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        eventService.delete(id);
    }
}
