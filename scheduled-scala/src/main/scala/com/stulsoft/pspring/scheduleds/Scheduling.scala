/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduleds

import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.{EnableScheduling, Scheduled}

/**
  * @author Yuriy Stul
  */
@Configuration
@ConditionalOnProperty(value = Array("app.scheduling.enable"), havingValue = "true", matchIfMissing = true)
@EnableScheduling
class Scheduling extends LazyLogging {
  @Autowired
  val someComponent: SomeComponent = null

  @Scheduled(fixedDelay = 2000)
  def scheduleFixedDelay(): Unit = {
    logger.info("==>scheduleFixedDelay")
    someComponent.work()
    logger.info("<==scheduleFixedDelay")
  }
}
