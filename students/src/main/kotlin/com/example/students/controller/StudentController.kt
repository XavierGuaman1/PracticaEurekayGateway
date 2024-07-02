package com.example.students.controller

import com.example.students.model.Students
import com.example.students.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class StudentController{
    @Autowired
    lateinit var studentService: StudentService

    @GetMapping
    fun list():String{
        return "estudiantes"
    }

    @PostMapping
    fun save (@RequestBody students: Students): ResponseEntity<Students> {
        return ResponseEntity(studentService.save(students), HttpStatus.OK )
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(studentService.listById (id), HttpStatus.OK)

        }

}