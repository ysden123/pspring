/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import javax.inject.Inject
import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers, Suite}
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration, Profile}
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ActiveProfiles, ContextConfiguration, TestContextManager}

/** Unit test for Scala and Spring with mocking
  *
  * @author Yuriy Stul
  */
class SomeServiceWithMockTest extends FunSuite with SpringSomeServiceWithMockTest with Matchers {
  @Inject
  val ss: SomeService = null

  test("testUseF1") {
    ss.useF1 should be("mock test")
  }

}

@ContextConfiguration(
  classes = Array(classOf[TestSomeServiceWithMockConfig]),
  loader = classOf[AnnotationConfigContextLoader]
)
@ActiveProfiles(Array("ssMock"))
trait SpringSomeServiceWithMockTest extends BeforeAndAfterEach {
  this: Suite =>
  override protected def beforeEach(): Unit = {
    new TestContextManager(classOf[SpringSomeServiceWithMockTest]).prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackages = Array("com.stulsoft.pspring.scala"))
@Configuration
@Profile(Array("ssMock"))
class TestSomeServiceWithMockConfig {
  @Bean
  def st: SomeTrait = new SomeMock
}

class SomeMock extends SomeTrait {
  override def f1: String = "mock test"
}
