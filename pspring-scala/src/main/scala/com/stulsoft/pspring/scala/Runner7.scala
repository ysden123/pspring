package com.stulsoft.pspring.scala

import org.springframework.boot.SpringApplication

/**
  * @author Yuriy Stul
  * @since 4/1/2018
  */
object Runner7 {
  def main(args: Array[String]): Unit = {
    println("==>Runner7")
    val applications:Array[Class[_]] = Array(classOf[Application4], classOf[Application4])
    SpringApplication.run(applications, args).close()
    println("<==Runner7")
  }
}
