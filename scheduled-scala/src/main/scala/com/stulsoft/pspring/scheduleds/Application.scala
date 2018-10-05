/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduleds

import com.typesafe.scalalogging.LazyLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.context.annotation.PropertySource

/**
  * @author Yuriy Stul
  */
@SpringBootApplication(scanBasePackages = Array("com.stulsoft.pspring.scheduleds"))
@PropertySource(Array("classpath:application.properties"))
class Application extends CommandLineRunner with LazyLogging {

  override def run(args: String*): Unit = {
    logger.info("==>run")

    logger.info("<==run")
  }
}

object Application extends App with LazyLogging {
  logger.info("==>Application")
  SpringApplication.run(classOf[Application], args: _*)
  logger.info("<==Application")
}
