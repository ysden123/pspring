/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.springframework.boot.SpringApplication

/**
  * @author Yuriy Stul
  */
object Runner {
  def main(args: Array[String]): Unit = {
    println("==>main")
    SpringApplication.run(classOf[App], "mode1", "param11", "1000").close()
    SpringApplication.run(classOf[App], "mode2", "param12", "2000").close()
    println("<==main")
  }
}
