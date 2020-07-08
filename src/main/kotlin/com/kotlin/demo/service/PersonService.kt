package com.kotlin.demo.service

import com.kotlin.demo.dto.AddPersonRequest
import com.kotlin.demo.dto.PersonResponse
import com.kotlin.demo.dto.UpdatePersonRequest

interface PersonService {
    fun findAll(): List<PersonResponse>
    fun findById(id: Long): PersonResponse?
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteById(id:Long)
}