package com.stulsoft.pspring.mysql.application

import org.springframework.data.repository.CrudRepository

/**
  * @author Yuriy Stul
  * @since 4/17/2018
  */
trait UserRepository extends CrudRepository[User, Long]
