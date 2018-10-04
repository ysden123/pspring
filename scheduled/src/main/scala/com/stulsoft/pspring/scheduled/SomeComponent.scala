/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduled

import com.typesafe.scalalogging.LazyLogging
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@Component
class SomeComponent extends LazyLogging {
  def work(): Unit = {
    logger.info("==>work")
    logger.info("<==work")
  }
}
