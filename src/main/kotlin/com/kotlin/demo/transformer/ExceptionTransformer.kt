package com.kotlin.demo.transformer

import com.kotlin.demo.dto.ErrorResponse

fun Exception.toErrorResponse(): ErrorResponse {
    return ErrorResponse(
            title = this::class.java.simpleName,
            message = this.localizedMessage
    )
}