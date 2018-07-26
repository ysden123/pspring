/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers, Suite}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ContextConfiguration, TestContextManager}

/**
  * @author Yuriy Stul
  */
@RunWith(classOf[JUnitRunner])
class SomeServiceTest extends FunSuite with SpringSomeServiceTest with Matchers {
  @Autowired
  val ss: SomeService = null

  test("testUseF1") {
    ss.useF1 should be("implementation 1")
  }

}

@ContextConfiguration(
  classes = Array(classOf[ProdSomeServiceConfig]),
  loader = classOf[AnnotationConfigContextLoader])
trait SpringSomeServiceTest extends BeforeAndAfterEach {
  this: Suite =>

  override def beforeEach(): Unit = {
    new TestContextManager(classOf[SpringSomeServiceTest]).prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackages = Array("com.stulsoft.pspring.scala"))
@Configuration
class ProdSomeServiceConfig {
}