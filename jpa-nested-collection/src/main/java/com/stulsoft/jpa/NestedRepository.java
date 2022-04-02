package com.stulsoft.jpa;

import org.springframework.data.repository.CrudRepository;

public interface NestedRepository extends CrudRepository<Nested, Long> {
}
