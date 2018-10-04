/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduled

import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FunSuite, Suite}
import org.scalatest.junit.JUnitRunner
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ContextConfiguration, TestContextManager, TestPropertySource}

/**
  * @author Yuriy Stul
  */
//@RunWith(classOf[JUnitRunner])
@RunWith(classOf[SpringJUnit4ClassRunner])
@TestPropertySource(properties = Array("app.scheduling.enable=false"))
class ApplicationTest extends FunSuite with SpringApplicationTest {

  test("testScheduleFixedDelay") {
    val app = new Application
    app.scheduleFixedDelay()
  }
}

@TestPropertySource(properties = Array("app.scheduling.enable=false"))
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

@TestPropertySource(properties = Array("app.scheduling.enable=false"))
@ComponentScan(basePackages = Array("com.stulsoft.pspring.scheduled"))
@Configuration
class SomeComponentConfig {
}