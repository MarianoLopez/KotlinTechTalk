package com.kotlin.demo.resource

import com.kotlin.demo.dto.AddPersonRequest
import com.kotlin.demo.dto.PersonResponse
import com.kotlin.demo.dto.UpdatePersonRequest
import com.kotlin.demo.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/person")
class PersonResourceImpl(private val personService: PersonService): PersonResource {

    @GetMapping
    override fun findAll(): ResponseEntity<List<PersonResponse>> {
        return ResponseEntity.ok(personService.findAll())
    }

    @GetMapping("/{id}")
    override fun findById(@PathVariable id:Long): ResponseEntity<PersonResponse?> {
        val person = personService.findById(id)
        val status = if (person != null) HttpStatus.OK else HttpStatus.NO_CONTENT

        return ResponseEntity.status(status).body(person)
    }

    @PostMapping
    override fun save(@RequestBody addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(addPersonRequest))
    }

    @PutMapping
    override fun update(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> {
        return ResponseEntity.ok(personService.update(updatePersonRequest))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        personService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}