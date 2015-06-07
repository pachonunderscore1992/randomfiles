package org.fabriquita.nucleus.repositories;

import org.fabriquita.nucleus.models.Place;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {

}
