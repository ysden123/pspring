/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.simple.web.app

import org.springframework.web.bind.annotation.{RequestMapping, RestController}

/**
  * @author Yuriy Stul
  */
@RestController
class Controller {
  @RequestMapping(Array("/")) def index: String = "Greetings from Spring Boot!"
}
