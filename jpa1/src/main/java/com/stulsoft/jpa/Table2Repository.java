/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface Table2Repository extends CrudRepository<Table2, Long> {
    Optional<Table2> findById(Long id);

/*
    @Query("select t2 from Table2 t2")
    List<Table2> findAll();
*/
}
