/*
 * Copyright (c) 2018. Yuriy Stul
 */

/**
  * @author Yuriy Stul
  */
package com.stulsoft.pspring.scheduleds

import org.scalatest.funsuite.FunSuite


class SomeServiceTest extends FunSuite {

  test("testDoServiceWork") {
    (new SomeService).doServiceWork()
    assert(true)
  }

}
