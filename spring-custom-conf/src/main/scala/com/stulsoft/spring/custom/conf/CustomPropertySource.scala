/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.spring.custom.conf

import java.io.FileInputStream
import java.util.Properties

import com.typesafe.scalalogging.LazyLogging

/** Custom property source
  *
  * @param fileName specifies the file with properties
  * @author Yuriy Stul
  */
case class CustomPropertySource(fileName: String) extends LazyLogging {
  /**
    * Builds properties
    *
    * Current version builds properties from a file, but a source may be DB, XML, what ever.
    *
    * @return the properties
    */
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
}
