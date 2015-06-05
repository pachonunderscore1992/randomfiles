package org.fabriquita.nucleus.services;

import java.util.List;

import org.fabriquita.nucleus.models.Post;
import org.fabriquita.nucleus.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> list() {
        return Lists.newLinkedList(postRepository.findAll());
    }

    public Post get(Long id) {
        return postRepository.findOne(id);
    }

    public Post add(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    public Post update(Long id, String title, String content, Integer likes) {
        Post post = postRepository.findOne(id);
        if(title != null) {
            post.setTitle(title);
        }
        if(content != null) {
            post.setContent(content);
        }
        if(likes != null) {
            post.setLikes(likes);
        }
        return postRepository.save(post);
    }

    public void delete(Long id) {
        Post post = postRepository.findOne(id);
        postRepository.delete(post);
    }

}
