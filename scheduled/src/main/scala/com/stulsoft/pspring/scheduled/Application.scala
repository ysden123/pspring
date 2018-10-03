/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduled

import com.typesafe.scalalogging.LazyLogging
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.{EnableScheduling, Scheduled}

/**
  * @author Yuriy Stul
  */
@SpringBootApplication(scanBasePackages = Array("com.stulsoft.pspring.scheduled"))
@EnableScheduling
class Application extends CommandLineRunner with LazyLogging {
  override def run(args: String*): Unit = {
    logger.info("==>run")

    logger.info("<==run")
  }

  @Scheduled(fixedDelay = 2000)
  def scheduleFixedDelay():Unit={
    logger.info("==>scheduleFixedDelay")
    logger.info("<==scheduleFixedDelay")
  }
}

object Application extends App with LazyLogging {
  logger.info("==>Application")
//  SpringApplication.run(classOf[Application], args: _*).close()
  SpringApplication.run(classOf[Application], args: _*)
  logger.info("<==Application")
}
