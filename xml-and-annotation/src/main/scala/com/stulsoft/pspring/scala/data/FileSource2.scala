/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.data

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
class FileSource2 extends DataSource {
  @Autowired
  val fileDataProvider: FileDataProvider2 = null

  override def data(): String = fileDataProvider.data()
}
