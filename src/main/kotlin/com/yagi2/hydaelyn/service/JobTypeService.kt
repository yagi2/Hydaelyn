package com.yagi2.hydaelyn.service

import com.yagi2.hydaelyn.model.entity.JobType
import com.yagi2.hydaelyn.repository.JobTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class JobTypeService {

    @Autowired
    lateinit var repository: JobTypeRepository

    fun selectAll(): List<JobType> = repository.findAll(Sort(Sort.Direction.ASC, "id"))

    fun findById(id: Int): List<JobType> = repository.findById(id)

    fun findByName(name: String): List<JobType> = repository.findByName(name)
    fun findByNameContain(name: String): List<JobType> = repository.findByNameContainsOrderByIdAsc(name)
}