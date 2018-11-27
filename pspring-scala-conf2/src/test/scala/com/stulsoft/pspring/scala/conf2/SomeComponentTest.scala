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
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ContextConfiguration, TestContextManager, TestPropertySource}

@RunWith(classOf[SpringJUnit4ClassRunner])
//@TestPropertySource(Array("file:config/test/application.properties"))
@TestPropertySource(Array("file:application.properties"))
class SomeComponentTest extends FunSuite with Matchers with SpringSomeComponentTest {
  @Autowired private val someComponent: SomeComponent = null

  test("testBoolArg1") {
    val result = someComponent.boolArg1()
    println(s"result = $result")
  }
}

@ContextConfiguration(
  classes = Array(classOf[SomeComponentTestConfig]),
  loader = classOf[AnnotationConfigContextLoader])
trait SpringSomeComponentTest extends BeforeAndAfterEach {
  this: Suite =>
  override protected def beforeEach(): Unit = {
    System.setProperty("spring.config.location", s"config/test/")
    new TestContextManager(classOf[SpringSomeComponentTest]).prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackageClasses = Array(classOf[com.stulsoft.pspring.scala.conf2.SomeComponent]))
@Configuration
class SomeComponentTestConfig {}