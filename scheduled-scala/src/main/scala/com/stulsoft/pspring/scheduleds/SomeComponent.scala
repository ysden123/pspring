/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduleds

import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  */
@Component
class SomeComponent(@Autowired() val someService: SomeService) extends LazyLogging {
  def work(): Unit = {
    logger.info("==>work")
    someService doServiceWork()
    logger.info("<==work")
  }
}
