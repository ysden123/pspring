package com.stulsoft.pspring.scala

import org.springframework.boot.SpringApplication

/**
  * @author Yuriy Stul
  * @since 3/29/2018
  */
object Runner3 {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application3], args: _*).close()
  }
}
