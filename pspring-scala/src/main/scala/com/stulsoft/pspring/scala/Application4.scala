package com.stulsoft.pspring.scala

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * @author Yuriy Stul
  * @since 4/1/2018
  */
@SpringBootApplication
class Application4  extends CommandLineRunner {
  override def run(strings: String*): Unit = {
    println("==>run")
    val worker = new Worker1
    worker.start()
  }
}
