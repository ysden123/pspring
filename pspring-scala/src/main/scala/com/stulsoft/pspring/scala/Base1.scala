/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.springframework.context.annotation.Bean

/**
  * @author Yuriy Stul
  */
class Base1 {
//  @Bean(Array("str1"))
  @Bean
  def str1: String = "the str1"

  def run():Unit = ???
}
