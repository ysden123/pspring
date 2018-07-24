/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import java.util.concurrent.ScheduledExecutorService

import org.springframework.context.annotation.Bean
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@Component
class Beans {
  @Bean(destroyMethod = "shutdown") def executor: ScheduledExecutorService = {
    taskScheduler.getScheduledExecutor
  }

  @Bean(destroyMethod = "shutdown") def taskScheduler: ThreadPoolTaskScheduler = {
    val ret = new ThreadPoolTaskScheduler()
    ret.setPoolSize(17)
    ret.initialize()
    ret
  }

}
