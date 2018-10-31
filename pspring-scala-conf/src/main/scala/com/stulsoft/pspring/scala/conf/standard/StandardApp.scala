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
class StandardApp  extends CommandLineRunner  {
  @Inject
  private var environment: AbstractEnvironment = _

//  @Inject
//  var env:Environment = _

  override def run(args: String*): Unit = {
    println("==>run")
    println(s"""environment.getProperty("test.test1")=${environment.getProperty("test.test1")}""")
    println("<==run")
  }
}
