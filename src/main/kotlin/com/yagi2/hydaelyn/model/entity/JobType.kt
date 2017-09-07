package com.yagi2.hydaelyn.model.entity

import javax.persistence.*

@Entity
@Table(name = "job_type")
data class JobType(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "name")
        val name: String
)