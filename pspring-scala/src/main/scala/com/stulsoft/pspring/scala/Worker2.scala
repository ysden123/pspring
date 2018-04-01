package com.stulsoft.pspring.scala

/**
  * @author Yuriy Stul
  * @since 4/1/2018
  */
class Worker2 extends Thread {
  override def run(): Unit = {
    println("==>Worker2.run")
    (1 to 6).foreach(i => {
      println(s"Worker2: i = $i")
      Thread.sleep(1000)
    })
    println("<==Worker2.run")
  }
}
