/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.slf4j.LoggerFactory

/**
  * @author Yuriy Stul
  */
object Application {
  private val logger = LoggerFactory.getLogger(Application.getClass)

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    logger.info("<==main")
  }
}
