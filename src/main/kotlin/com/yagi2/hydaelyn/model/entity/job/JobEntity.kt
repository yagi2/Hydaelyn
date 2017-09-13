package com.yagi2.hydaelyn.model.entity.job

import javax.persistence.*

@Entity
@Table(name = "job")
data class JobEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "name")
        val name: String,

        @Column(name = "type")
        val jobTypeId: Int
)