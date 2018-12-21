/*
 * Copyright (c) 2018. Yuriy Stul
 */

/**
  * @author Yuriy Stul
  */
package com.stulsoft.pspring.scala.conf

import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers, Suite}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ContextConfiguration, TestContextManager}

@RunWith(classOf[SpringJUnit4ClassRunner])
class SomeComponentTest extends FunSuite with Matchers with SpringSomeComponentTest {
  @Autowired private val someComponent: SomeComponent = null

  test("testBoolArg1") {
    val result = someComponent.boolArg1()
    result shouldBe "false"
  }

  test("test1") {
    val result = someComponent.test1()
    result shouldBe "some_test_value for unit test"
  }
}

@ContextConfiguration(
  classes = Array(classOf[SomeComponentTestConfig]),
  loader = classOf[AnnotationConfigContextLoader])
trait SpringSomeComponentTest extends BeforeAndAfterEach {
  this: Suite =>
  override protected def beforeEach(): Unit = {
    System.setProperty("prop_prefix", "test")
    new TestContextManager(classOf[SpringSomeComponentTest]).prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackageClasses = Array(classOf[com.stulsoft.pspring.scala.conf.SomeComponent]))
@Configuration
class SomeComponentTestConfig {}