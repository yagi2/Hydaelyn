package com.yagi2.hydaelyn.repository

import com.yagi2.hydaelyn.model.entity.Job
import org.springframework.data.jpa.repository.JpaRepository

interface JobRepository : JpaRepository<Job, Int> {
    fun findById(id: Int): List<Job>

    fun findByJobTypeId(jobTypeId: Int): List<Job>

    fun findByName(name: String): List<Job>
    fun findByNameContainsOrderByIdAsc(name: String): List<Job>
}