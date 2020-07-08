package com.kotlin.demo.transformer

import com.kotlin.demo.domain.Person
import com.kotlin.demo.dto.AddPersonRequest

fun AddPersonRequest.toPerson(): Person {
    return Person(name = this.name, lastName = this.lastName)
}