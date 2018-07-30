/*
 * Copyright (c) 2018. Yuriy Stul
 */

/**
  * @author Yuriy Stul
  */
package com.stulsoft.pspring.scala.data

import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers, Suite}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.test.context.{ContextConfiguration, TestContextManager}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader

@RunWith(classOf[SpringJUnit4ClassRunner])
class SqlSourceTest extends FlatSpec with SpringSqlSourceTest with Matchers {
  @Autowired
  val sqlSource: SqlSource = null

  behavior of "SqlSourceTest"

  "data" should "return data" in {
    sqlSource.data() should be("sql data")
  }
}

@ContextConfiguration(
  classes = Array(classOf[SqlSourceTestConfig]),
  loader = classOf[AnnotationConfigContextLoader]
)
trait SpringSqlSourceTest extends BeforeAndAfterEach {
  this: Suite =>
  override def beforeEach(): Unit = {
    new TestContextManager(classOf[SpringSqlSourceTest]).prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackages = Array("com.stulsoft.pspring.scala"))
@Configuration
class SqlSourceTestConfig{}