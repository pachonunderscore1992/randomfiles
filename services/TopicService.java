package org.fabriquita.nucleus.services;

import java.util.List;

import org.fabriquita.nucleus.models.Post;
import org.fabriquita.nucleus.models.Topic;
import org.fabriquita.nucleus.repositories.PostRepository;
import org.fabriquita.nucleus.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    PostRepository postRepository;

    public List<Topic> list() {
        return Lists.newLinkedList(topicRepository.findAll());
    }

    public List<Post> getPosts(Long id) {
        return postRepository.findByTopicIdOrderByDateDesc(id);
    }

    public Topic get(Long id) {
        return topicRepository.findOne(id);
    }

    public Topic add(String name) {
        Topic topic = new Topic();
        topic.setName(name);
        return topicRepository.save(topic);
    }

    public Topic update(Long id, String name) {
        Topic topic = topicRepository.findOne(id);
        topic.setName(name);
        return topicRepository.save(topic);
    }

    public void delete(Long id) {
        Topic topic = topicRepository.findOne(id);
        topicRepository.delete(topic);
    }

}
