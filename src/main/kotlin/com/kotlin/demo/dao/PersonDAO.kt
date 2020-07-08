package com.kotlin.demo.dao

import com.kotlin.demo.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDAO: JpaRepository<Person, Long>