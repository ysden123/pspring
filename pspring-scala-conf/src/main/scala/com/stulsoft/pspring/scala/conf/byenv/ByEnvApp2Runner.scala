/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.conf.byenv

import org.springframework.boot.SpringApplication

/**
  * @author Yuriy Stul
  */
object ByEnvApp2Runner {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[ByEnvApp2], args: _*).close()
  }
}
