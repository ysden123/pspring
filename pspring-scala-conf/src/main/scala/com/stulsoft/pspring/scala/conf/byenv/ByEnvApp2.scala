/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.conf.byenv

import javax.inject.Inject
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.{AbstractEnvironment, Environment}

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
@PropertySource(Array("classpath:${TEST_ENV}.application.properties"))
class ByEnvApp2 extends CommandLineRunner {
//  @Inject
//  private var environment: AbstractEnvironment = _
  @Inject
  private var env: Environment = _

  override def run(args: String*): Unit = {
    println("==>ByEnvApp2 run")
    println(s"""environment.getProperty("test.test1")=${env.getProperty("test.test1")}""")
    println("<==ByEnvApp2 run")
  }

}
