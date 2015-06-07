package org.fabriquita.nucleus.controllers;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.fabriquita.nucleus.models.Post;
import org.fabriquita.nucleus.models.Topic;
import org.fabriquita.nucleus.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Topic> list() {
        return topicService.list();
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Topic get(@PathVariable(value = "id") Long id) {
        return topicService.get(id);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getPost(@PathVariable(value = "id") Long id) {
        return topicService.getPosts(id);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Topic add(@RequestBody Map<String, Object> data) {
        String name = null;
        if (data.get("name") != null) {
            name = (String) data.get("name");
        }
        return topicService.add(name);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Topic update(@PathVariable(value = "id") Long id,
            @RequestBody Map<String, Object> data) {
        String name = null;
        if (data.get("name") != null) {
            name = (String) data.get("name");
        }
        return topicService.update(id, name);
    }

    @RequiresAuthentication
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        topicService.delete(id);
    }
}
