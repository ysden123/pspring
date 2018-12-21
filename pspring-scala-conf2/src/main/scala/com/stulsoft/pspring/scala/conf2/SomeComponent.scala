/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.conf2

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@Component
class SomeComponent {
  @Autowired
  private val env: Environment = null

  def boolArg1(): String = env.getProperty("bool-arg1")
  def test1(): String = env.getProperty("test.test1")
}
