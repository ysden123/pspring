/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.scalatest.FlatSpec

/**
  * @author Yuriy Stul
  */
class SomeImpl1Test extends FlatSpec {

  behavior of "SomeImpl1Test"

  it should "f1" in {
    val si = new SomeImpl1()
    assert(si.f1() == "Implementation 1")
  }
}
