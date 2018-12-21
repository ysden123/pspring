/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.spring.custom.conf

import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers, Suite}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{ComponentScan, Configuration, PropertySource}
import org.springframework.test.context.{ContextConfiguration, TestContextManager}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader

/**
  * @author Yuriy Stul
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
class SomeComponentTest extends FunSuite with Matchers with SpringSomeComponentTest {
  @Autowired private val someComponent: SomeComponent = null
  test("testBoolArg1") {
    someComponent.boolArg1() shouldBe "true"
  }

  test("testTest1") {
    someComponent.test1() shouldBe "some test data for test of SomeComponent"
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

@ComponentScan(basePackageClasses = Array(classOf[com.stulsoft.spring.custom.conf.SomeComponent]))
@Configuration
@PropertySource(Array("classpath:test2.app.properties"))
class SomeComponentTestConfig {}