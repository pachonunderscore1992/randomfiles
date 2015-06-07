package org.fabriquita.nucleus.repositories;

import java.util.List;

import org.fabriquita.nucleus.models.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    public List<Post> findByTopicIdOrderByDateDesc(Long id);

    public List<Post> findAllByOrderByDateDesc();

}