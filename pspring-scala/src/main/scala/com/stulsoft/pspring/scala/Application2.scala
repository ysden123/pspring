package com.stulsoft.pspring.scala

import javax.inject.Inject
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.core.env.{AbstractEnvironment, Environment}

/**
  * @author Yuriy Stul
  * @since 3/6/2018
  */
@SpringBootApplication
class Application2 extends CommandLineRunner {
  @Inject
  private var environment: AbstractEnvironment = _

  @Inject
  var env:Environment = _

  override def run(strings: String*): Unit = {
    println("==>Application2.run")
    println(s"""environment.getProperty("test.test1")=${environment.getProperty("test.test1")}""")
    environment.getProperty("test.test1")

    if (env.getProperty("bool-arg1", classOf[Boolean], false))
      println("bool-arg1 is true")
    else
      println("bool-arg1 is false")
    if (env.getProperty("bool-arg2", classOf[Boolean], false))
      println("bool-arg2 is true")
    else
      println("bool-arg2 is false")

    println("<==Application2.run")
  }
}
