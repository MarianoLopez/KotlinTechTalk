package com.kotlin.demo.dto

data class UpdatePersonRequest (val id:Long, val name:String, val lastName:String? = null)