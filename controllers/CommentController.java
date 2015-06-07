package org.fabriquita.nucleus.controllers;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.fabriquita.nucleus.models.Comment;
import org.fabriquita.nucleus.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> list() {
        return commentService.list();
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment get(@PathVariable(value = "id") Long id) {
        return commentService.get(id);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment add(@RequestBody Map<String, Object> data) {
        String content = null;
        Long postId = null;
        if (data.get("content") != null) {
            content = (String) data.get("content");
        }
        if (data.get("post_id") != null) {
            postId = new Long(data.get("post_id").toString());
        }
        return commentService.add(postId, content);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment update(@PathVariable(value = "id") Long id,
            @RequestBody Map<String, Object> data) {
        String content = null;
        if (data.get("content") != null) {
            content = (String) data.get("content");
        }
        return commentService.update(id, content);
    }

    @RequiresAuthentication
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        commentService.delete(id);
    }

}
