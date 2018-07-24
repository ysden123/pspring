/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import java.util.concurrent.ScheduledExecutorService

import javax.inject.Inject
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.{EnableScheduling, SchedulingConfigurer}
import org.springframework.scheduling.config.ScheduledTaskRegistrar

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
@EnableScheduling
class App extends CommandLineRunner with InitializingBean with SchedulingConfigurer {
  override def run(args: String*): Unit = {
    println("==>App.run")
    args.foreach(println)
    new Worker(args(0), args(1), args(2).toLong).start()
    println("<==App.run")
  }

  @Inject
  var executor: ScheduledExecutorService = _

  override def afterPropertiesSet(): Unit = {
    println("==>afterPropertiesSet")
  }

  override def configureTasks(taskRegistrar: ScheduledTaskRegistrar): Unit = {
    println("==>configureTasks")
    taskRegistrar.setScheduler(executor)
  }
}
