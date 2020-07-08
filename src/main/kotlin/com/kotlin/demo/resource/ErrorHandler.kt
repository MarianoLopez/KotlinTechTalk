package com.kotlin.demo.resource

import com.kotlin.demo.dto.ErrorResponse
import com.kotlin.demo.transformer.toErrorResponse
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(IllegalStateException::class, EmptyResultDataAccessException::class)
    fun handleIllegalStateException(exception:Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(exception.toErrorResponse())
    }
}