/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import javax.inject.Inject
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers, Suite}
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration, Profile}
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ActiveProfiles, ContextConfiguration, TestContextManager}

/** Demonstrates use of ScalaTest with ScalaMock on Spring
  *
  * @author Yuriy Stul
  */
class SomeServiceWithScalaMockTest extends FunSuite
  with SpringSomeServiceWithScalaMockTest
  with Matchers {

  @Inject
  val ss: SomeService = null

  test("testUseF1") {
    val text = "Scala mock test"
    TestData.f1Text = text
    ss.useF1 should be(text)
  }

  test("testUseF1 2") {
    val text = "Scala mock test 2"
    TestData.f1Text = text
    ss.useF1 should be(text)
  }
}

@ContextConfiguration(
  classes = Array(
    classOf[TestSomeServiceWithScalaMockConfig]),
  loader = classOf[AnnotationConfigContextLoader]
)
@ActiveProfiles(Array("ssScalaMock"))
trait SpringSomeServiceWithScalaMockTest extends BeforeAndAfter {
  this: Suite =>
  before {
    new TestContextManager(classOf[SpringSomeServiceWithScalaMockTest])
      .prepareTestInstance(this)
  }
}

@ComponentScan(basePackages = Array("com.stulsoft.pspring.scala"))
@Configuration
@Profile(Array("ssScalaMock"))
class TestSomeServiceWithScalaMockConfig extends MockFactory {
  @Bean
  def st: SomeTrait = {
    println("Initializing stub...")
    val theStub = stub[SomeTrait]

    // Dynamically returns a current value of the TestData.f1Text
    // If to use (theStub.f1 _).when().returning(...) then always a first value (null) will be returned!
    (theStub.f1 _).when().onCall(() => {
      TestData.f1Text
    })
    theStub
  }
}

/**
  * Holds a data for emulation of tests
  */
object TestData {
  var f1Text: String = _
}
