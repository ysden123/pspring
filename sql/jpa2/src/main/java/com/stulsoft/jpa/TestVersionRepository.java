/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TestVersionRepository extends CrudRepository<TestVersion, Long> {
    Optional<TestVersion> findById(Long id);

/*
    @Query("select t1 from Table1 t1")
    List<Table1> findAll();
*/

/*
    @Query("SELECT t1, t2 FROM Table1 t1 LEFT JOIN Table2 t2 ON t1.name = t2.name")
    List<Object> test1();
*/

}
