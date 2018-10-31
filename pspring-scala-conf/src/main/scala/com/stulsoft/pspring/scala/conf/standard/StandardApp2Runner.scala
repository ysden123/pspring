/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.conf.standard

import org.springframework.boot.SpringApplication

/**
  * @author Yuriy Stul
  */
object StandardApp2Runner {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[StandardApp2], args: _*).close()
  }
}
