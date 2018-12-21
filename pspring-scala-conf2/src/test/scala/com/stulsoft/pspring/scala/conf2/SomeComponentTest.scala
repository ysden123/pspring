/*
 * Copyright (c) 2018. Yuriy Stul
 */

/**
  * @author Yuriy Stul
  */
package com.stulsoft.pspring.scala.conf2

import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers, Suite}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{ComponentScan, Configuration, PropertySource}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ContextConfiguration, TestContextManager}

@RunWith(classOf[SpringJUnit4ClassRunner])
class SomeComponentTest extends FunSuite with Matchers with SpringSomeComponentTest {
  @Autowired private val someComponent: SomeComponent = null

  test("testBoolArg1") {
    val result = someComponent.boolArg1()
    result shouldBe "true"
  }

  test("test1") {
    val result = someComponent.test1()
    result shouldBe "some_test_value for test"
  }
}

@ContextConfiguration(
  classes = Array(classOf[SomeComponentTestConfig]),
  loader = classOf[AnnotationConfigContextLoader])
trait SpringSomeComponentTest extends BeforeAndAfterEach {
  this: Suite =>
  override protected def beforeEach(): Unit = {
    val testContextManager = new TestContextManager(classOf[SpringSomeComponentTest])
    testContextManager.prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackageClasses = Array(classOf[com.stulsoft.pspring.scala.conf2.SomeComponent]))
@Configuration
@PropertySource(Array("file:config/test/application.properties"))
class SomeComponentTestConfig {}