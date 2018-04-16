package com.stulsoft.pspring.scala

import javax.inject.Inject

import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  * @since 3/6/2018
  */
@Component
class MyConf @Inject()(var env: Environment) {
  def test(): Unit = {
    println("==>test")
    println(s"""env.getProperty("test.test1") = ${env.getProperty("test.test1")}""")
    if (env.getProperty("bool-arg1", classOf[Boolean], false))
      println("bool-arg1 is true")
    else
      println("bool-arg1 is false")
    if (env.getProperty("bool-arg2", classOf[Boolean], false))
      println("bool-arg2 is true")
    else
      println("bool-arg2 is false")
    env.getProperty("test.test1")
  }
}
