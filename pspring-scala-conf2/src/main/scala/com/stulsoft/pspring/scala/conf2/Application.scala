/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.conf2

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.core.env.Environment

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
class Application extends CommandLineRunner {
  @Autowired
  private var env: Environment = _

  @Autowired
  private var someComponent: SomeComponent = _

  override def run(args: String*): Unit = {
    println("==>run")
    println(s"""env.getProperty("test.test1")=${env.getProperty("test.test1")}""")
    println(s"""someComponent.boolArg1()=${someComponent.boolArg1()}""")
    println("<==run")
  }
}
