package com.stulsoft.pspring.scala

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * @author Yuriy Stul
  * @since 4/2/2018
  */
@SpringBootApplication
class App1 extends CommandLineRunner {
  override def run(args: String*): Unit = {
    println("==>App1.run")
    args.foreach(println)
    println("<==App1.run")
  }
}
