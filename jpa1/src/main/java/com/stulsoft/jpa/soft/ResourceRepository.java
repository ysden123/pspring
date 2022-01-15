/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa.soft;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    @Query("select r from Resource r where r.name in :names")
    List<Resource> findResourcesByNames(@Param("names") List<String> names);
}
