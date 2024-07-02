package com.example.grades.model

import jakarta.persistence.*

@Entity
@Table(name = "grades")
class Grades {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name: String? =null
    var Subject: String? =null
    var grade: String?=null

}