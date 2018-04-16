package com.stulsoft.pspring.scala

/**
  * @author Yuriy Stul
  * @since 3/29/2018
  */
trait MyInterface {
  def foo(): Unit = {
    println("==>foo")
  }

  def bar(): Unit
}
