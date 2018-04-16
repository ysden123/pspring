/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.mysql.data

import org.springframework.data.repository.CrudRepository

/**
  * @author Yuriy Stul
  */
abstract class UserSRepository extends CrudRepository[UserS, Long] {

}
