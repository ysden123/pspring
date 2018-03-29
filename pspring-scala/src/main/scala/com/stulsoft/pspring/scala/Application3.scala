package com.stulsoft.pspring.scala

import javax.inject.{Inject, Named}
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * @author Yuriy Stul
  * @since 3/29/2018
  */
@SpringBootApplication
class Application3 extends CommandLineRunner {
  @Inject
  @Named("myInterface1")
  var myInterfaceImpl1 : MyInterface = _

  @Inject
  @Named("myInterface2")
  var myInterfaceImpl2 : MyInterface = _

  override def run(strings: String*): Unit = {
    println("==>Application3.run")
    myInterfaceImpl1.foo()
    myInterfaceImpl1.bar()

    myInterfaceImpl2.foo()
    myInterfaceImpl2.bar()


    println("<==Application3.run")
  }
}
