/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TableAllRepository extends CrudRepository<TableAll, Long> {
    @Query("select tot from TableAll tot where tot.name in :names")
    List<TableAll> getByNames(@Param("names") List<String> names);
}
