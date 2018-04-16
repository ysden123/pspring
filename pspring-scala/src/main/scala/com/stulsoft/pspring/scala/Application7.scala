/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import javax.inject.Inject
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
class Application7 extends CommandLineRunner {
  @Inject
  var impl:Impl2 = _
  override def run(strings: String*): Unit = {
    impl.run()
  }
}
