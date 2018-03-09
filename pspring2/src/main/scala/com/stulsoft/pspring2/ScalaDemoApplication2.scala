/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring2

import org.slf4j.LoggerFactory
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
class ScalaDemoApplication2 extends CommandLineRunner{
  val logger = LoggerFactory.getLogger(classOf[ScalaDemoApplication2])
  override def run(args: String*): Unit = {
    logger.info("==>ScalaDemoApplication2.run")
  }
}

object ScalaDemoApplication2 extends App{
  val logger = LoggerFactory.getLogger(classOf[ScalaDemoApplication2])
  logger.info("==>ScalaDemoApplication2.main")
  SpringApplication.run(classOf[ScalaDemoApplication2], args: _*).close()
}
