/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.springframework.stereotype.{Component, Service}

/**
  * @author Yuriy Stul
  */
//@Component("impl1")
@Service(value = "impl1")
class Impl1 extends Base1 {
  override def run(): Unit = println(s"(1) str1 = $str1")
}
