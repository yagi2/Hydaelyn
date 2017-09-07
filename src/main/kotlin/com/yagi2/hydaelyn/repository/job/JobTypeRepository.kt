package com.yagi2.hydaelyn.repository.job

import com.yagi2.hydaelyn.model.entity.job.JobType
import org.springframework.data.jpa.repository.JpaRepository

interface JobTypeRepository : JpaRepository<JobType, Int> {
    fun findById(Id: Int): List<JobType>

    fun findByName(name: String): List<JobType>
    fun findByNameContainsOrderByIdAsc(name: String): List<JobType>
}