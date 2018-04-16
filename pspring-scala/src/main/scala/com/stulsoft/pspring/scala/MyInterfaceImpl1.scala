package com.stulsoft.pspring.scala

import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  * @since 3/29/2018
  */
@Component("myInterface1")
class MyInterfaceImpl1 extends MyInterface {
  override def bar(): Unit = println("==>MyInterfaceImpl1.bar")
}
