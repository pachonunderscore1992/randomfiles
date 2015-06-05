package org.fabriquita.nucleus.repositories;

import org.fabriquita.nucleus.models.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long>{

}
