package org.launchcode.mytrythymeleaf.data;

import org.launchcode.mytrythymeleaf.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Integer> {

}
