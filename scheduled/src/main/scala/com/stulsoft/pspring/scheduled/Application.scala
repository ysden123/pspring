/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduled

import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.context.annotation.{Configuration, PropertySource}
import org.springframework.scheduling.annotation.{EnableScheduling, Scheduled}

/**
  * @author Yuriy Stul
  */
@SpringBootApplication(scanBasePackages = Array("com.stulsoft.pspring.scheduled"))
@PropertySource(Array("classpath:application.properties"))
@Configuration
@EnableScheduling
class Application extends CommandLineRunner with LazyLogging {
  @Autowired
  val someComponent: SomeComponent = null

  override def run(args: String*): Unit = {
    logger.info("==>run")

    logger.info("<==run")
  }

  @Scheduled(fixedDelay = 2000)
  def scheduleFixedDelay(): Unit = {
    logger.info("==>scheduleFixedDelay")
    someComponent.work()
    logger.info("<==scheduleFixedDelay")
  }
}

object Application extends App with LazyLogging {
  logger.info("==>Application")
  SpringApplication.run(classOf[Application], args: _*)
  logger.info("<==Application")
}
