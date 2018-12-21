/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.spring.custom.conf

import org.scalatest.{FunSuite, Matchers}

/**
  * @author Yuriy Stul
  */
class CustomPropertySourceTest extends FunSuite with Matchers {

  test("testProperties") {
    val customPropertySource = CustomPropertySource(fileNameFromResource("test1.properties"))
    customPropertySource.properties().getProperty("p1.v1") shouldBe "some test value"
  }

  test("testProperties with wrong file name") {
    val customPropertySource = CustomPropertySource("ERROR.properties")
    customPropertySource.properties().getProperty("p1.v1") shouldBe null
  }

}
