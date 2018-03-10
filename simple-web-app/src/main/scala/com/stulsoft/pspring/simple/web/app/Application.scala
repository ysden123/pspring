/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.simple.web.app


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.context.ApplicationContext

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
class Application extends CommandLineRunner {

  import org.springframework.beans.factory.annotation.Autowired

  @Autowired private val appContext: ApplicationContext = null

  override def run(args: String*): Unit = {
    println("Let's inspect the beans provided by Spring Boot:")
    appContext.getBeanDefinitionNames.sorted.foreach(println)
  }
}

object Application {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application], args: _*)
  }
}