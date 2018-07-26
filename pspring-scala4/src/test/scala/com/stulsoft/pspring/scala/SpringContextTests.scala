/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation._
import org.springframework.stereotype.Service
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ActiveProfiles, ContextConfiguration, TestContextManager}

/**
  * See [[https://gist.github.com/shishkin/f3ce94fb601f63cdf1f5]]
  *
  * @author Yuriy Stul
  */
@RunWith(classOf[JUnitRunner])
class SpringContextTests extends FunSuite with SpringTest with Matchers {

  @Autowired
  val foo: FooService = null

  test("wiring works") {
    foo.foo should be("test")
  }
}

@ContextConfiguration(
  classes = Array(classOf[TestConfig], classOf[ProdConfig]),
  loader = classOf[AnnotationConfigContextLoader])
@ActiveProfiles(Array("test"))
trait SpringTest extends BeforeAndAfterEach {
  this: Suite =>

  override def beforeEach(): Unit = {
    new TestContextManager(classOf[SpringTest]).prepareTestInstance(this)
    super.beforeEach()
  }
}

@Configuration
@Profile(Array("test"))
class TestConfig {

  @Bean
  def foo: FooService = new FooMock
}

@ComponentScan(basePackages = Array("com.stulsoft.pspring.scala"))
@Configuration
@Profile(Array("prod"))
class ProdConfig {
}

trait FooService {
  def foo: String
}

@Service
class Foo extends FooService {
  override def foo = "bar"
}

class FooMock extends FooService {
  override def foo = "test"
}