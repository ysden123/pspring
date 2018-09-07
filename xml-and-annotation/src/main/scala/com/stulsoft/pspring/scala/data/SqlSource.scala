/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.data

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.{Component, Service}

/**
  * @author Yuriy Stul
  */
@Component
class SqlSource extends DataSource {
  @Autowired(required = true)
  val sqlDataProvider: SqlDataProvider = null

  override def data(): String = sqlDataProvider.data()
}
