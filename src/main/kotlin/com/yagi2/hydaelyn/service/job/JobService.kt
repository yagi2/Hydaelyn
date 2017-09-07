package com.yagi2.hydaelyn.service.job

import com.yagi2.hydaelyn.model.entity.job.Job
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

    fun selectAll(): List<Job> = repository.findAll(Sort(Sort.Direction.ASC, "id"))

    fun findById(id: Int): List<Job> = repository.findById(id)

    fun findByType(jobTypeId: Int): List<Job> = repository.findByJobTypeId(jobTypeId)

    fun findByName(name: String): List<Job> = repository.findByName(name)
    fun findByNameContain(name: String): List<Job> = repository.findByNameContainsOrderByIdAsc(name)
}