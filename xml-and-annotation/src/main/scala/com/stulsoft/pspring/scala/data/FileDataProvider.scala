/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.data

import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@Component
class FileDataProvider {
  def data(): String = "file data"
}
