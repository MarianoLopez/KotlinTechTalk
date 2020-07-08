package com.kotlin.demo

import com.kotlin.demo.dao.PersonDAO
import com.kotlin.demo.domain.Person
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication(private val personDAO: PersonDAO): ApplicationRunner {
	override fun run(args: ApplicationArguments?) {
		val personsToInsert = listOf(
				Person(name = "Mariano", lastName = "Lopez"),
				Person(name = "Emanuel"),
				Person(name = "Alejandro")
		)
		personDAO.saveAll(personsToInsert)
	}

}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
