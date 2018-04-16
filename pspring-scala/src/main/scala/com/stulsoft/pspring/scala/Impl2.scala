/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.springframework.stereotype.{Component, Service}

/**
  * @author Yuriy Stul
  */
//@Component("impl2")
@Service(value = "impl2")
class Impl2 extends Base1 {
  override def run(): Unit = println(s"(2) str1 = $str1")
}
