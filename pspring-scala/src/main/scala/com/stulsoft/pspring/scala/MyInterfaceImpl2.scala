package com.stulsoft.pspring.scala

import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  * @since 3/29/2018
  */
@Component("myInterface2")
class MyInterfaceImpl2 extends MyInterface {
  override def bar(): Unit = println("==>MyInterfaceImpl2.bar")
}
