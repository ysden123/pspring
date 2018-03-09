/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring2

import java.io.PrintStream

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.core.env.Environment

/** Customized banner
  *
  * Works, if ''resources'' folder doesn't contains ''banner.txt'' file
  *
  * @author Yuriy Stul
  */
@SpringBootApplication
class ScalaDemoApplication3 extends CommandLineRunner {
  private val logger = LoggerFactory.getLogger(classOf[ScalaDemoApplication3])

  override def run(args: String*): Unit = {
    logger.info("==>ScalaDemoApplication3.run")
  }
}

object ScalaDemoApplication3 {
  def main(args: Array[String]): Unit = {
    val app = new SpringApplication(classOf[ScalaDemoApplication3])
    app.setBanner((_: Environment, _: Class[_], out: PrintStream) => {
      out.print(print("\n\n\tThis is my own banner!\n\n".toUpperCase()))
    })

    app.run(args: _*)
  }
}
