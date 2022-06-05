package com.stulsoft.pspring2

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * @author Yuriy Stul
  * @since 3/18/2018
  */
@Component
@Autowired
class  Component1{
  private val logger = LoggerFactory.getLogger(classOf[Component1])
  logger.info("In the constructor of Component1")
}
