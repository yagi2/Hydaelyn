package com.yagi2.hydaelyn.model.entity.job

import javax.persistence.*

@Entity
@Table(name = "job_type")
data class JobTypeEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "name")
        val name: String
)