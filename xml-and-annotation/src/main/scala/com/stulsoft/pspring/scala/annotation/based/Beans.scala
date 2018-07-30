/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala.annotation.based

import com.stulsoft.pspring.scala.data.{FileSource, SqlSource}
import com.stulsoft.pspring.scala.service.Processor
import javax.inject.Inject
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * @author Yuriy Stul
  */
@Configuration
class Beans {

  @Inject
  val sqlDataSource: SqlSource = null

  @Inject
  val fileDataSource: FileSource = null

  @Bean(Array("sqlProcessor"))
  def sql: Processor = {
    val p = new Processor
    p.setDataSource(sqlDataSource)
    p
  }

  @Bean(Array("fileProcessor"))
  def file: Processor = {
    val p = new Processor
    p.setDataSource(fileDataSource)
    p
  }
}
