/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.service

import com.stulsoft.pspring.scala.data.DataSource

/**
  * @author Yuriy Stul
  */
class Processor {
  var dataSource: DataSource = _

  def data(): String = dataSource.data()

  def setDataSource(dataSource: DataSource): Unit = {
    this.dataSource = dataSource
  }
}
