package com.stulsoft.pspring2

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * @author Yuriy Stul
  * @since 3/18/2018
  */
@Service
@Autowired
class Service1 {
  private val logger = LoggerFactory.getLogger(classOf[Service1])
  logger.info("In the constructor of Service1")
}
