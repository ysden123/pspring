/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.data

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@Component
class FileSource extends DataSource {
  @Autowired
  val fileDataProvider: FileDataProvider = null

  override def data(): String = fileDataProvider.data()
}
