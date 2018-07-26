/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import javax.inject.Inject
import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FlatSpec}
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.test.context.{ContextConfiguration, TestContextManager}
import org.springframework.test.context.junit4.{SpringJUnit4ClassRunner, SpringRunner}
import org.springframework.test.context.support.AnnotationConfigContextLoader

/**
  * @author Yuriy Stul
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(
  locations = Array("com.stulsoft.pspring.scala"),
  loader = classOf[AnnotationConfigContextLoader])
class Usage1Test extends FlatSpec with BeforeAndAfterEach {

  @Inject var st2: SomeTrait = _

  new TestContextManager(this.getClass()).prepareTestInstance(this)

  override def beforeEach() {

  }

  @Configuration
  object Config {
//    @Bean val st: SomeTrait = new SomeImpl1()
    @Bean def st(): SomeTrait = new SomeImpl1()
  }

  behavior of "Usage1Test"

  it should "f1" in {
    //    val u1 = new Usage1
    //    assert(u1.f1() == "Implementation 1")
    assert(st2.f1() == "Implementation 1")
  }
}
