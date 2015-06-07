package org.fabriquita.nucleus.repositories;

import org.fabriquita.nucleus.models.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends PagingAndSortingRepository<Topic, Long> {

}