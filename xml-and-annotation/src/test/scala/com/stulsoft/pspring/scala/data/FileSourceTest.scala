/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.data

import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers, Suite}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.{ContextConfiguration, TestContextManager}

/**
  * @author Yuriy Stul
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
class FileSourceTest extends FlatSpec with SpringFileSourceTest with Matchers {
  @Autowired
  val fileSource: FileSource = null

  behavior of "FileSource"

  "data" should "return data" in {
    fileSource.data() should be("file data")
  }

}

@ContextConfiguration(
  classes = Array(classOf[FileSourceTestConfig]),
  loader = classOf[AnnotationConfigContextLoader]
)
trait SpringFileSourceTest extends BeforeAndAfterEach {
  this: Suite =>
  override def beforeEach(): Unit = {
    new TestContextManager(classOf[SpringFileSourceTest]).prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackages = Array("com.stulsoft.pspring.scala"))
@Configuration
class FileSourceTestConfig {}
