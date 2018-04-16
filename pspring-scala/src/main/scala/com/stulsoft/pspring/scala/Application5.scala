package com.stulsoft.pspring.scala

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * @author Yuriy Stul
  * @since 4/1/2018
  */
@SpringBootApplication
class Application5 extends CommandLineRunner {
  override def run(strings: String*): Unit = {
    println("==>run")
    val worker = new Worker2
    worker.start()
  }
}
