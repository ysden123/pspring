/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.annotation.based

import com.stulsoft.pspring.scala.service.Processor
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication

/**
  * @author Yuriy Stul
  */
object App {
  private val logger = LoggerFactory.getLogger(classOf[App])

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    val ctx = SpringApplication.run(classOf[AppConfig], args: _*)
    ctx.getBeanDefinitionNames.foreach(n => logger.info(s"Bean: $n"))

    // instantiate the sql and file objects from the application context
    val sql = ctx.getBean("sqlProcessor").asInstanceOf[Processor]
    val file = ctx.getBean("fileProcessor").asInstanceOf[Processor]

    // let them speak
    logger.info(s"sql.data() ${sql.data()}")
    logger.info(s"file.data() ${file.data()}")
    logger.info("<==main")
  }
}
