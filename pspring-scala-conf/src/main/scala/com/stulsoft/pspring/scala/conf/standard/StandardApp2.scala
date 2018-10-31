/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.conf.standard

import javax.inject.Inject
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.core.env.{AbstractEnvironment, Environment}

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
class StandardApp2 extends CommandLineRunner  {
    @Inject
    var env:Environment = _

  override def run(args: String*): Unit = {
    println("==>run")
    println(s"""env.getProperty("test.test1")=${env.getProperty("test.test1")}""")
    println("<==run")
  }
}
