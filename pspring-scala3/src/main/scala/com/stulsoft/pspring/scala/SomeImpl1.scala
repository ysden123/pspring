/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
class SomeImpl1 extends SomeTrait {
  override def f1(): String = "Implementation 1"
}
