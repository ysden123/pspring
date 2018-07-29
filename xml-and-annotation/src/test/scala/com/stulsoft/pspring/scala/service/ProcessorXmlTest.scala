/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.service

import com.stulsoft.pspring.scala.Application
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}
import org.slf4j.LoggerFactory
import org.springframework.context.support.ClassPathXmlApplicationContext

/** Configuration from XML file
  *
  * @author Yuriy Stul
  */
class ProcessorXmlTest extends FlatSpec with BeforeAndAfterEach with Matchers {
  private val logger = LoggerFactory.getLogger(Application.getClass)
  private var processor: Processor = _


  behavior of "ProcessorTest"

  "data" should "return data" in {
    processor shouldNot equal(null)
    processor.data() should equal("test data")
  }

  override protected def beforeEach(): Unit = {
    val ctx = new ClassPathXmlApplicationContext("processor-test1.xml")
    processor = ctx.getBean(classOf[Processor])
    super.beforeEach()
  }
}
