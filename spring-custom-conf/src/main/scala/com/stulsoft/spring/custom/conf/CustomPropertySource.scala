/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.spring.custom.conf

import java.io.FileInputStream
import java.util.Properties

import com.typesafe.scalalogging.LazyLogging

/**
  * @author Yuriy Stul
  */

/** Custom property source
  *
  * @param fileName specifies the file with properties
  */
case class CustomPropertySource(fileName: String) extends LazyLogging {
  def properties(): Properties = {
    val properties = new Properties()
    try {
      properties.load(new FileInputStream(fileName))
    } catch {
      case e: Exception =>
        logger.error(s"Failed loading properties from '$fileName'. Error: ${e.getMessage}")
    }
    properties
  }

  /*
  def propertySource():Unit={
    val sources: MutablePropertySources = ???
    sources.addFirst(new PropertiesPropertySource("customSource", ))
  }
  */
}
