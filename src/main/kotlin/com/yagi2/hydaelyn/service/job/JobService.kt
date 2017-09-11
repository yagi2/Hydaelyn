package com.yagi2.hydaelyn.service.job

import com.yagi2.hydaelyn.model.entity.job.JobEntity
import com.yagi2.hydaelyn.repository.job.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class JobService {

    @Autowired
    lateinit var repository: JobRepository

    fun selectAll(): List<JobEntity> = repository.findAll(Sort(Sort.Direction.ASC, "id"))

    fun findById(id: Int): List<JobEntity> = repository.findById(id)

    fun findByType(jobTypeId: Int): List<JobEntity> = repository.findByJobTypeId(jobTypeId)

    fun findByName(name: String): List<JobEntity> = repository.findByName(name)
    fun findByNameContain(name: String): List<JobEntity> = repository.findByNameContainsOrderByIdAsc(name)
}