/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduled

import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.{Conditional, Configuration, PropertySource}
import org.springframework.scheduling.annotation.{EnableScheduling, Scheduled}
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@SpringBootApplication(scanBasePackages = Array("com.stulsoft.pspring.scheduled"))
@PropertySource(Array("classpath:application.properties"))
//@ConditionalOnProperty(
//  value = Array("app.scheduling.enable"),
//  havingValue = "false",
//  matchIfMissing = false
//)
@EnableScheduling
class Application extends CommandLineRunner with LazyLogging {
  @Autowired
  val someComponent: SomeComponent = null

  override def run(args: String*): Unit = {
    logger.info("==>run")

    logger.info("<==run")
  }

  @ConditionalOnProperty(
    value = Array("app.scheduling.enable"),
    havingValue = "false",
    matchIfMissing = false
  )
  @Scheduled(fixedDelay = 2000)
  def scheduleFixedDelay(): Unit = {
    logger.info("==>scheduleFixedDelay")
    someComponent.work()
    logger.info("<==scheduleFixedDelay")
  }
}

object Application extends App with LazyLogging {
  logger.info("==>Application")
  //  SpringApplication.run(classOf[Application], args: _*).close()
  SpringApplication.run(classOf[Application], args: _*)
  logger.info("<==Application")
}
