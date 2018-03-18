package com.stulsoft.pspring2

import org.slf4j.LoggerFactory
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * @author Yuriy Stul
  * @since 3/18/2018
  */
@SpringBootApplication
class ServiceComponentRunner extends CommandLineRunner {
  private val logger = LoggerFactory.getLogger(classOf[ServiceComponentRunner])
  override def run(args: String*): Unit = {
    logger.info("In the ServiceComponentRunner")
  }
}

object ServiceComponentRunner{
  def main(args: Array[String]): Unit = {
    new SpringApplication(classOf[ServiceComponentRunner]).run().close()
  }
}