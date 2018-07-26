/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scala

import javax.inject.Inject
import org.springframework.stereotype.Service

/**
  * @author Yuriy Stul
  */
@Service
class SomeService {
    @Inject
    val st: SomeTrait = null

    def useF1: String = st.f1
}
