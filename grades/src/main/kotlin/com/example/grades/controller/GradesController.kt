package com.example.grades.controller

import com.example.grades.model.Grades
import com.example.grades.service.GradesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class GradesController{
    @Autowired
    lateinit var gradesService: GradesService

    @GetMapping
    fun list():String{
        return "grades"
    }

    @PostMapping
    fun save (@RequestBody grades: Grades): ResponseEntity<Grades> {
        return ResponseEntity(gradesService.save(grades), HttpStatus.OK )
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(gradesService.listById (id), HttpStatus.OK)

        }

}