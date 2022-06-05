/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring2

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.boot.ApplicationArguments
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@Component
@Autowired
class MyComponent1(val args: ApplicationArguments) {
  private val logger = LoggerFactory.getLogger(classOf[MyComponent1])

  @Value("${data.server}")
  val server:String = null

  logger.info("==>MyComponent1")
  logger.info(s"args.getSourceArgs.length = ${args.getSourceArgs.length}")

  def defineServer():String = server
}
