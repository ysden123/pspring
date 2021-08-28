/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.restapi.data;

/**
 * @author Yuriy Stul
 */
public record AbstractResult<T>(T data, String error) {
}
