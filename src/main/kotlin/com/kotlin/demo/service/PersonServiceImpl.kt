package com.kotlin.demo.service

import com.kotlin.demo.dao.PersonDAO
import com.kotlin.demo.domain.Person
import com.kotlin.demo.dto.AddPersonRequest
import com.kotlin.demo.dto.PersonResponse
import com.kotlin.demo.dto.UpdatePersonRequest
import com.kotlin.demo.transformer.toPerson
import com.kotlin.demo.transformer.toPersonResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(private val personDAO: PersonDAO) : PersonService {
    override fun findAll(): List<PersonResponse> {
        return personDAO.findAll().map(Person::toPersonResponse)
    }

    override fun findById(id: Long): PersonResponse? {
        return findPersonById(id)?.toPersonResponse()
    }

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return saveOrUpdate(addPersonRequest.toPerson())
    }

    @Throws(IllegalStateException::class)
    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person:Person = findPersonById(updatePersonRequest.id) ?: throw IllegalStateException("Person not found")

        person.apply {
            name = updatePersonRequest.name
            lastName = updatePersonRequest.lastName
        }
        return saveOrUpdate(person)
    }

    override fun deleteById(id: Long) = personDAO.deleteById(id)

    private fun saveOrUpdate(person: Person): PersonResponse {
        return personDAO.save(person).toPersonResponse()
    }

    private fun findPersonById(id:Long): Person? = personDAO.findByIdOrNull(id)
}