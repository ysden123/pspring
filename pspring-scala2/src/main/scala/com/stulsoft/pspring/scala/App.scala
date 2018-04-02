package com.stulsoft.pspring.scala

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * @author Yuriy Stul
  * @since 4/2/2018
  */
@SpringBootApplication
class App extends CommandLineRunner {
  override def run(args: String*): Unit = {
    println("==>App.run")
    args.foreach(println)
    new Worker(args(0), args(1), args(2).toLong).start
    println("<==App.run")
  }
}
