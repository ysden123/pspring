package com.stulsoft.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ContainerRepository extends CrudRepository<Container, Long> {

    @Query("SELECT c.nested.name, n2 FROM Container c JOIN c.nested2 n2 WHERE c.type IN ?1")
    List findSpecial(Collection<String> containerTypes);
}
