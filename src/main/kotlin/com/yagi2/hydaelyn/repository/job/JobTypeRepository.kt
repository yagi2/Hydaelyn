package com.yagi2.hydaelyn.repository.job

import com.yagi2.hydaelyn.model.entity.job.JobTypeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JobTypeRepository : JpaRepository<JobTypeEntity, Int> {
    fun findById(Id: Int): List<JobTypeEntity>

    fun findByName(name: String): List<JobTypeEntity>
    fun findByNameContainsOrderByIdAsc(name: String): List<JobTypeEntity>
}