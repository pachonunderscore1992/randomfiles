package org.fabriquita.nucleus.controllers;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.fabriquita.nucleus.models.Place;
import org.fabriquita.nucleus.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Place> list() {
        return placeService.list();
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Place get(@PathVariable(value = "id") Long id) {
        return placeService.get(id);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Place add(@RequestBody Map<String, Object> data) {
        String name = null;
        String address = null;
        if (data.get("name") != null) {
            name = (String) data.get("name");
        }
        if (data.get("address") != null) {
            address = (String) data.get("address");
        }
        return placeService.add(name, address);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Place update(@PathVariable(value = "id") Long id,
            @RequestBody Map<String, Object> data) {
        String name = null;
        String address = null;
        if (data.get("name") != null) {
            name = (String) data.get("name");
        }
        if (data.get("address") != null) {
            address = (String) data.get("address");
        }
        return placeService.update(id, name, address);
    }

    @RequiresAuthentication
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        placeService.delete(id);
    }
}
