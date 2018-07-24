/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

/**
  * @author Yuriy Stul
  */
class Worker(val arg1: String, val arg2: String, val delay: Long) extends Thread {
  override def run(): Unit = {
    println("==>Worker.run")
    (1 to 5).foreach(i => {
      println(s"Worker: arg1=$arg1, arg2=$arg2, i = $i")
      Thread.sleep(delay)
    })
    println("<==Worker.run")
  }
}
