/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.conf.byenv

import javax.inject.Inject
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.AbstractEnvironment

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
@PropertySource(Array("classpath:${TEST_ENV}.application.properties"))
class ByEnvApp2 extends CommandLineRunner {
  @Inject
  private var environment: AbstractEnvironment = _

  override def run(args: String*): Unit = {
    println("==>run")
    println(s"""environment.getProperty("test.test1")=${environment.getProperty("test.test1")}""")
    println("<==run")
  }

}
