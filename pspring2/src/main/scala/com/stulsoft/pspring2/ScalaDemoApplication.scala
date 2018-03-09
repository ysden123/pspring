/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring2

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
class ScalaDemoApplication{

}

object ScalaDemoApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[ScalaDemoApplication], args: _*)
  }
}
