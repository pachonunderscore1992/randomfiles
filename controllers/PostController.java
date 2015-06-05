package org.fabriquita.nucleus.controllers;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.fabriquita.nucleus.models.Post;
import org.fabriquita.nucleus.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    PostService postService;

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> list() {
        return postService.list();
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Post get(@PathVariable(value = "id") Long id) {
        return postService.get(id);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Post add(@RequestBody Map<String, Object> data) {
        String title = null;
        String content = null;
        if (data.get("title") != null) {
            title = (String) data.get("title");
        }
        if (data.get("content") != null) {
            content = (String) data.get("content");
        }
        return postService.add(title,content);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Post update(@PathVariable(value = "id") Long id,
            @RequestBody Map<String, Object> data) {
        String title = null;
        String content = null;
        Integer likes = null;
        if (data.get("title") != null) {
            title = (String) data.get("title");
        }
        if (data.get("content") != null) {
            content = (String) data.get("content");
        }
        if (data.get("likes") != null) {
            likes = new Integer(data.get("likes").toString());
        }
        return postService.update(id, title, content, likes);
    }

    @RequiresAuthentication
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        postService.delete(id);
    }

}
