/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * @author Yuriy Stul
  */
@Service
class SomeService {
    @Autowired
    val st: SomeTrait = null

    def useF1: String = st.f1
}
