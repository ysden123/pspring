/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.mysql.data;

import org.springframework.data.repository.CrudRepository;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 * @author Yuriy Stul
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
