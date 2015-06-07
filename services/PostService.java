package org.fabriquita.nucleus.services;

import java.util.List;

import org.fabriquita.nucleus.models.Comment;
import org.fabriquita.nucleus.models.Post;
import org.fabriquita.nucleus.models.Topic;
import org.fabriquita.nucleus.repositories.CommentRepository;
import org.fabriquita.nucleus.repositories.PostRepository;
import org.fabriquita.nucleus.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    CommentRepository commentRepository;

    public List<Post> list() {
        return Lists.newLinkedList(postRepository.findAllByOrderByDateDesc());
    }

    public List<Comment> getComments(Long id){
        return Lists.newLinkedList(commentRepository.findByPostIdOrderByDateDesc(id));
    }

    public Post get(Long id) {
        return postRepository.findOne(id);
    }

    public Post add(Long topicId, String title, String content) {
        Post post = new Post();
        Topic topic = topicRepository.findOne(topicId);
        post.setTitle(title);
        post.setContent(content);
        post.setTopic(topic);
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
