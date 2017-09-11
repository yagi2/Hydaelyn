package com.yagi2.hydaelyn.controller.job

import com.yagi2.hydaelyn.model.entity.job.JobEntity
import com.yagi2.hydaelyn.service.job.JobService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/job")
class JobController {

    @Autowired
    lateinit var service: JobService

    @RequestMapping(value = "/", method = arrayOf(RequestMethod.GET))
    fun selectAll(): List<JobEntity> = service.selectAll()

    @RequestMapping(value = "/search", method = arrayOf(RequestMethod.GET))
    fun search(@RequestParam(name = "name", required = false) name: String?,
               @RequestParam(name = "type", required = false) jobTypeId: Int?,
               @RequestParam(name = "id", required = false) id: Int?): List<JobEntity> {

        val redundantList = mutableListOf<MutableList<JobEntity>>()

        name?.let {
            if (name.isNotBlank()) {
                redundantList.add(mutableListOf())
                redundantList[redundantList.size - 1].addAll(service.findByNameContain(name))
            }
        }

        jobTypeId?.let {
            redundantList.add(mutableListOf())
            redundantList[redundantList.size - 1].addAll(service.findByType(jobTypeId))
        }

        id?.let {
            redundantList.add(mutableListOf())
            redundantList[redundantList.size - 1].addAll(service.findById(id))
        }

        val result = mutableListOf<JobEntity>()

        redundantList.forEach {
            it.forEach { job ->
                if (redundantList.all { it.contains(job) } && result.contains(job).not()) {
                    result.add(job)
                }
            }
        }

        return result
    }
}