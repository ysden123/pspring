/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduled

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterEach, FunSuite, Suite}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ContextConfiguration, TestContextManager}

/**
  * @author Yuriy Stul
  */
//@RunWith(classOf[JUnitRunner])
@RunWith(classOf[SpringJUnit4ClassRunner])
class ApplicationTest extends FunSuite with SpringApplicationTest {
  @Autowired
  val app: Application = null

  test("testScheduleFixedDelay") {
    app.scheduleFixedDelay()
  }
}

@ContextConfiguration(
  classes = Array(classOf[SomeComponentConfig]),
  loader = classOf[AnnotationConfigContextLoader])
trait SpringApplicationTest extends BeforeAndAfterEach {
  this: Suite =>
  override protected def beforeEach(): Unit = {
    new TestContextManager(classOf[SpringApplicationTest]).prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackages = Array("com.stulsoft.pspring.scheduled"))
@Configuration
class SomeComponentConfig {
}