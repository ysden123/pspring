/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.annotation.based

import javax.inject.Inject
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext

/** Usage of annotation-based configuration
  * @author Yuriy Stul
  */
@SpringBootApplication(scanBasePackages = Array("com.stulsoft.pspring.scala"))
class AppConfig @Inject()(ctx: ApplicationContext) extends CommandLineRunner {
  private val logger = LoggerFactory.getLogger(classOf[AppConfig])

  override def run(args: String*): Unit = {
    logger.info("==>run")
    logger.info("<==run")
  }
}
