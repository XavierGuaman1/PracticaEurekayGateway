package com.example.students.service

import com.example.students.model.Students
import com.example.students.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class StudentService {
    @Autowired
    lateinit var studentRepository: StudentRepository

    fun list (pageable: Pageable, students: Students ): Page<Students> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("name"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return studentRepository.findAll(Example.of(students, matcher), pageable)
    }

    fun save(students: Students): Students {
        try{
            students.address?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return studentRepository.save(students)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?): Students? {
        return studentRepository.findById(id)
        }

}