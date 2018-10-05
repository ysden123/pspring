/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduleds

import com.typesafe.scalalogging.LazyLogging
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@Component
class SomeService extends LazyLogging {
  def doServiceWork(): Unit = {
    logger.info("==>doServiceWork")
    logger.info("<==doServiceWork")
  }
}
