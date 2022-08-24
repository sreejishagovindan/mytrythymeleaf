package org.launchcode.mytrythymeleaf.data;

import org.launchcode.mytrythymeleaf.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends CrudRepository<EventCategory,Integer> {
}
