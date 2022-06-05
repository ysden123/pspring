/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.mysql

import com.stulsoft.pspring.mysql.application.Application
import org.springframework.boot.SpringApplication

object Runner {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application], args: _*).close()
  }
}