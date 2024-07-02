package com.example.grades.service



import com.example.grades.model.Grades
import com.example.grades.repository.GradesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class GradesService {
    @Autowired
    lateinit var gradesRepository: GradesRepository

    fun list (pageable: Pageable, grades: Grades): Page<Grades> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("name"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return gradesRepository.findAll(Example.of(grades, matcher), pageable)
    }

    fun save(grades: Grades): Grades {
        try{
            grades.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return gradesRepository.save(grades)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?): Grades? {
        return gradesRepository.findById(id)
        }

}