/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.spring.custom

import java.io.File

/**
  * @author Yuriy Stul
  */
package object conf {
  /**
    * Returns an absolute path to file in resource
    *
    * @param resourceName the resource name
    * @return the absolute path to file in resource
    */
  def fileNameFromResource(resourceName: String): String = new File(getClass
    .getClassLoader
    .getResource(resourceName)
    .toURI)
    .getAbsolutePath
}
