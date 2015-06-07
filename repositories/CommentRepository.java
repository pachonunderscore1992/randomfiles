package org.fabriquita.nucleus.repositories;

import java.util.List;

import org.fabriquita.nucleus.models.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    public List<Comment> findByPostIdOrderByDateDesc(Long id);

}
