package org.fabriquita.nucleus.services;

import java.util.List;

import org.fabriquita.nucleus.models.Comment;
import org.fabriquita.nucleus.models.Post;
import org.fabriquita.nucleus.repositories.CommentRepository;
import org.fabriquita.nucleus.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    public List<Comment> list() {
        return Lists.newLinkedList(commentRepository.findAll());
    }

    public Comment get(Long id) {
        return commentRepository.findOne(id);
    }

    public Comment add(Long postId,String content) {
        Comment comment = new Comment();
        Post post = postRepository.findOne(postId);
        comment.setContent(content);
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    public Comment update(Long id, String content) {
        Comment comment = commentRepository.findOne(id);
        if(content != null) {
            comment.setContent(content);
        }
        return commentRepository.save(comment);
    }

    public void delete(Long id) {
        Comment comment = commentRepository.findOne(id);
        commentRepository.delete(comment);
    }

}
