package org.fabriquita.nucleus.services;

import java.util.Date;
import java.util.List;

import org.fabriquita.nucleus.models.Event;
import org.fabriquita.nucleus.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<Event> list() {
        return Lists.newLinkedList(eventRepository.findAll());
    }

    public Event get(Long id) {
        return eventRepository.findOne(id);
    }

    public Event add(String title, String description, Date date, String place) {
        Event event = new Event();
        event.setTitle(title);
        event.setDescription(description);
        event.setDate(date);
        event.setPlace(place);
        return eventRepository.save(event);
    }

    public Event update(Long id, String title, String description, Date date, String place) {
        Event event = eventRepository.findOne(id);
        if(title != null) {
            event.setTitle(title);
        }
        if(description != null) {
            event.setDescription(description);
        }
        if(date != null) {
            event.setDate(date);
        }
        if(place != null){
            event.setPlace(place);
        }
        return eventRepository.save(event);
    }

    public void delete(Long id) {
        Event event = eventRepository.findOne(id);
        eventRepository.delete(event);
    }
}
