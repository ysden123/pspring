/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.conf.standard

import org.springframework.boot.SpringApplication

/**
  * @author Yuriy Stul
  */
object StandardAppRunner {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[StandardApp], args: _*).close()
  }
}
