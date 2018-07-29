/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.service

import com.stulsoft.pspring.scala.Application
import javax.inject.Inject
import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.{ApplicationContext, ApplicationContextAware}
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader

/**
  * @author Yuriy Stul
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array("/processor-test1.xml"),
  loader = classOf[AnnotationConfigContextLoader])
@Configuration
class ProcessorXmlTest extends FlatSpec with Matchers{
  private val logger = LoggerFactory.getLogger(Application.getClass)
  @Autowired
  private var processor: Processor = _

  behavior of "ProcessorTest"

  "data" should "return data" in {
    processor shouldNot equal(null)
    processor.data() should equal("test data")
  }

}
