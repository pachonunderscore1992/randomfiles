package org.fabriquita.nucleus.services;

import java.util.List;

import org.fabriquita.nucleus.models.Place;
import org.fabriquita.nucleus.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository placeRepository;

    public List<Place> list() {
        return Lists.newLinkedList(placeRepository.findAll());
    }

    public Place get(Long id) {
        return placeRepository.findOne(id);
    }

    public Place add(String name, String address) {
        Place place = new Place();
        place.setName(name);
        place.setAddress(address);
        return placeRepository.save(place);
    }

    public Place update(Long id, String name, String address) {
        Place place = placeRepository.findOne(id);
        place.setName(name);
        place.setAddress(address);
        return placeRepository.save(place);
    }

    public void delete(Long id) {
        Place place = placeRepository.findOne(id);
        placeRepository.delete(place);
    }
}
