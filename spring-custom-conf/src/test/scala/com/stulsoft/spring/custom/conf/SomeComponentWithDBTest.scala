/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.spring.custom.conf

import com.typesafe.scalalogging.LazyLogging
import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers, Suite}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation._
import org.springframework.core.env.{ConfigurableEnvironment, PropertiesPropertySource}
import org.springframework.test.context.{ContextConfiguration, TestContextManager}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader

/** Properties are read from DB ("db.app.properties" file)
  *
  * @author Yuriy Stul
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
class SomeComponentWithDBTest extends FunSuite with Matchers with SpringSomeComponentWithDBTest {
  @Autowired val someComponent: SomeComponent = null
  test("testBoolArg1") {
    someComponent.boolArg1() shouldBe "true"
  }

  test("testTest1") {
    someComponent.test1() shouldBe "some test data for test of SomeComponent with DB"
  }

}

@ContextConfiguration(
  classes = Array(classOf[SomeComponentWithDBTestConfig]),
  loader = classOf[AnnotationConfigContextLoader])
trait SpringSomeComponentWithDBTest extends BeforeAndAfterEach {
  this: Suite =>
  override protected def beforeEach(): Unit = {
    val testContextManager = new TestContextManager(classOf[SpringSomeComponentWithDBTest])
    testContextManager.prepareTestInstance(this)
    super.beforeEach()
  }
}

@ComponentScan(basePackageClasses = Array(classOf[com.stulsoft.spring.custom.conf.SomeComponent]))
@Configuration
class SomeComponentWithDBTestConfig extends LazyLogging {

  @Autowired
  private val env: ConfigurableEnvironment = null

  @Bean
  @Lazy(false)
  def initDBEnv(): CustomPropertySource = {
    logger.info("==>initDBEnv")
    val sources = env.getPropertySources
    val customPropertySource = CustomPropertySource(fileNameFromResource("db.app.properties"))
    sources.addFirst(new PropertiesPropertySource("customSource", customPropertySource.properties()))
    logger.info("<==initDBEnv")
    customPropertySource
  }
}