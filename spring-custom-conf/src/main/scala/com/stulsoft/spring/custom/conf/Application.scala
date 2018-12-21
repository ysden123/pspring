/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.spring.custom.conf

import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Bean, Lazy}
import org.springframework.core.env.{ConfigurableEnvironment, PropertiesPropertySource}

/**
  * @author Yuriy Stul
  */
@SpringBootApplication
class Application extends CommandLineRunner with LazyLogging {
  @Autowired
  private val env: ConfigurableEnvironment = null

  @Autowired
  private val someComponent: SomeComponent = null

  @Bean
  @Lazy(false)
  def initEnv(): CustomPropertySource = {
    logger.info("==>initEnv")
    val sources = env.getPropertySources
    val customPropertySource = CustomPropertySource(s"${System.getProperty("env.prefix")}.app.properties")
    sources.addFirst(new PropertiesPropertySource("customSource", customPropertySource.properties()))
    logger.info("<==initEnv")
    customPropertySource
  }

  override def run(args: String*): Unit = {
    println("==>run")
    println(s"""env.getProperty("test.test1")=${env.getProperty("test.test1")}""")
    println(s"""someComponent.boolArg1()=${someComponent.boolArg1()}""")
    println("<==run")
  }

}
