package com.kotlin.demo.resource

import com.kotlin.demo.dto.AddPersonRequest
import com.kotlin.demo.dto.PersonResponse
import com.kotlin.demo.dto.UpdatePersonRequest
import org.springframework.http.ResponseEntity

interface PersonResource {
    fun findAll(): ResponseEntity<List<PersonResponse>>
    fun findById(id:Long): ResponseEntity<PersonResponse?>
    fun save(addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse>
    fun update(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse>
    fun deleteById(id:Long): ResponseEntity<Unit>
}