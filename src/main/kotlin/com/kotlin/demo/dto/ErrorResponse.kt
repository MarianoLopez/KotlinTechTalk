package com.kotlin.demo.dto

import java.time.LocalDateTime

data class ErrorResponse (val title:String = "Error", val message: String = "", val date: LocalDateTime = LocalDateTime.now())