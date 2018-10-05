/*
 * Copyright (c) 2018. Yuriy Stul
 */

/**
  * @author Yuriy Stul
  */
package com.stulsoft.pspring.scheduleds

import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FunSuite, Suite}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ContextConfiguration, TestContextManager, TestPropertySource}

@RunWith(classOf[SpringJUnit4ClassRunner])
@TestPropertySource(properties = Array("app.scheduling.enable=false"))
class SomeComponentTest extends FunSuite with SpringSomeComponentTest {
  @Autowired private val someComponent: SomeComponent = null

  test("testWork") {
    someComponent work()
  }
}

@ContextConfiguration(
  classes = Array(classOf[SomeComponentConfig]),
  loader = classOf[AnnotationConfigContextLoader])
trait SpringSomeComponentTest extends BeforeAndAfterEach {
  this: Suite =>
  override protected def beforeEach(): Unit = {
    new TestContextManager(classOf[SpringSomeComponentTest]).prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackages = Array("com.stulsoft.pspring.scheduleds"))
@Configuration
class SomeComponentConfig {
}