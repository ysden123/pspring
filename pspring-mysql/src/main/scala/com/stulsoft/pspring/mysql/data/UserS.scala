/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.mysql.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


/**
  * @author Yuriy Stul
  */
@Entity // This tells Hibernate to make a table out of this class
class UserS {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Int = _
  var name: String = _
  var email: String = _
}
