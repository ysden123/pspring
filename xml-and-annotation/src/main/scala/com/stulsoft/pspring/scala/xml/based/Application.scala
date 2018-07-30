/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.xml.based

import com.stulsoft.pspring.scala.annotation.based.App.logger
import com.stulsoft.pspring.scala.service.Processor
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.support.ClassPathXmlApplicationContext

/** Usage of XML-based configuration
  * @author Yuriy Stul
  */
//@ComponentScan(basePackages = Array("com.stulsoft.pspring.scala"))
object Application {
  private val logger = LoggerFactory.getLogger(Application.getClass)

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    // open & read the application context file
    val ctx = new ClassPathXmlApplicationContext("app.xml")

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
