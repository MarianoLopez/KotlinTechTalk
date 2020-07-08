package com.kotlin.demo.transformer

import com.kotlin.demo.domain.Person
import com.kotlin.demo.dto.PersonResponse

fun Person.toPersonResponse(): PersonResponse {
    return PersonResponse(
            id = this.id,
            fullName = "${this.name}, ${this.lastName ?: ""}"
    )
}