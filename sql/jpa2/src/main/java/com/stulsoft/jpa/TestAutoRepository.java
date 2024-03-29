/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestAutoRepository extends JpaRepository<TestAuto, Long> {
    @Query(nativeQuery = true,
            value = "SELECT COUNT(*) FROM test_autos"
    )
    Integer findCount();

    @Query(nativeQuery = true,
            value = "SELECT MIN(name), MAX(name) FROM test_autos"
    )
    String[] findMinMaxNames();
}
