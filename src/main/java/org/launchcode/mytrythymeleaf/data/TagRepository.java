package org.launchcode.mytrythymeleaf.data;

import org.launchcode.mytrythymeleaf.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag,Integer> {
}
