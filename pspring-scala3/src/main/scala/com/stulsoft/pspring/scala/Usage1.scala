/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import javax.inject.Inject
import org.springframework.beans.factory.annotation.{Autowired, Configurable}
import org.springframework.stereotype.{Component, Service}

/**
  * @author Yuriy Stul
  */
//@Configurable
@Service
class Usage1 {
  @Inject
  var some: SomeTrait = _

  def f1(): String = some.f1()
}
