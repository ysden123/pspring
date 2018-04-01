package com.stulsoft.pspring.scala

/**
  * @author Yuriy Stul
  * @since 4/1/2018
  */
class Worker1 extends Thread {
  override def run(): Unit = {
    println("==>Worker1.run")
    (1 to 5).foreach(i => {
      println(s"Worker1: i = $i")
      Thread.sleep(1000)
    })
    println("<==Worker1.run")
  }
}
