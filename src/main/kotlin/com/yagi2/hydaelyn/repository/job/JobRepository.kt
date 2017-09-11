package com.yagi2.hydaelyn.repository.job

import com.yagi2.hydaelyn.model.entity.job.JobEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JobRepository : JpaRepository<JobEntity, Int> {
    fun findById(id: Int): List<JobEntity>

    fun findByJobTypeId(jobTypeId: Int): List<JobEntity>

    fun findByName(name: String): List<JobEntity>
    fun findByNameContainsOrderByIdAsc(name: String): List<JobEntity>
}