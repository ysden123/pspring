package com.stulsoft.pspring.scala

import org.springframework.boot.SpringApplication

/**
  * @author Yuriy Stul
  * @since 4/2/2018
  */
object Runner1 {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[App1], "mode1", "param11")
    SpringApplication.run(classOf[App1], "mode2", "param12")
  }
}
