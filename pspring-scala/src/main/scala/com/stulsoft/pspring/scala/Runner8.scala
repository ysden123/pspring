/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.springframework.boot.SpringApplication

/**
  * @author Yuriy Stul
  */
object Runner8 {
  def main(args: Array[String]): Unit = {
    val applications:Array[Class[_]] = Array(classOf[Application6], classOf[Application7])
    SpringApplication.run(applications, args).close()
  }
}
