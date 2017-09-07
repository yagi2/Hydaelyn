package com.yagi2.hydaelyn.model.entity

import javax.persistence.*

@Entity
@Table(name = "job")
data class Job(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "name")
        val name: String,

        @Column(name = "type")
        val jobTypeId: Int
)