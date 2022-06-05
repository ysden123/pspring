/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TestAutoRepository extends CrudRepository<TestAuto, Long> {
}
