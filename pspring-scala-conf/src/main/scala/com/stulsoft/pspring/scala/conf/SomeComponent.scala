/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.conf

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@Component
class SomeComponent {
  @Autowired
  private var env: Environment = _

  def boolArg1(): String = env.getProperty("bool-arg1")
}
