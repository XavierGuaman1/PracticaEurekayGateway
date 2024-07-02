package com.example.grades.repository

import com.example.grades.model.Grades
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface GradesRepository: JpaRepository<Grades, Long?> {
    fun findById (id: Long?):Grades?

}