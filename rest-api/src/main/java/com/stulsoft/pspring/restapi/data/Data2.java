/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.restapi.data;

import java.util.List;

/**
 * @author Yuriy Stul
 */
public record Data2(String name, List<Data1> data1List) {
}
