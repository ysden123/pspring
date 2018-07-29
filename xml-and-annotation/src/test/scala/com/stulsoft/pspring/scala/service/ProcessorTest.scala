/*
 * Copyright (c) 2018. Yuriy Stul
 */

/**
  * @author Yuriy Stul
  */
package com.stulsoft.pspring.scala.service

import com.stulsoft.pspring.scala.data.DataSource
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}
import org.springframework.beans.factory.annotation.Autowired

class ProcessorTest extends FlatSpec with BeforeAndAfterEach with Matchers {
  var processor: Processor = _

  override def beforeEach() {
    processor = new Processor
    processor.dataSource = new ProcessorTestDataSourceMock
  }

  behavior of "ProcessorTest"

  "data" should "return data" in {
    processor.data() should equal("test data")
  }
}

class ProcessorTestDataSourceMock extends DataSource {
  override def data(): String = "test data"
}