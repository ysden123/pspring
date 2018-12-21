/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.spring.custom.conf

import org.springframework.boot.SpringApplication

import scala.io.StdIn

/**
  * @author Yuriy Stul
  */
object Runner {
  def main(args: Array[String]): Unit = {
    println("==>main")
    println("Please enter an application properties file prefix (dev or prod):")
    val prefix = StdIn.readLine()
    System.setProperty("env.prefix", prefix)
    SpringApplication.run(classOf[Application], args: _*).close()
    println("<==main")
  }

}
