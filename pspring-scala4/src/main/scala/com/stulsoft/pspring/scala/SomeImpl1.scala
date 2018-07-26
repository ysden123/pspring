/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.springframework.stereotype.Service

/**
  * @author Yuriy Stul
  */
@Service
class SomeImpl1 extends SomeTrait {
  override def f1: String = "implementation 1"
}
