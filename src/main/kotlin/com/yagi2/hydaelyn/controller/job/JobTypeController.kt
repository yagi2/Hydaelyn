package com.yagi2.hydaelyn.controller.job

import com.yagi2.hydaelyn.model.entity.job.JobTypeEntity
import com.yagi2.hydaelyn.optimize
import com.yagi2.hydaelyn.service.job.JobTypeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/jobtype")
class JobTypeController {

    @Autowired
    lateinit var service: JobTypeService

    @RequestMapping(value = "/all", method = arrayOf(RequestMethod.GET))
    fun selectAll(): List<JobTypeEntity> = service.selectAll()

    @RequestMapping(value = "/search", method = arrayOf(RequestMethod.GET))
    fun search(@RequestParam(value = "name", required = false) name: String?,
               @RequestParam(value = "id", required = false) id: Int?): List<JobTypeEntity> {

        val redundantList = mutableListOf<MutableList<JobTypeEntity>>()

        name?.let {
            if (name.isNotBlank()) {
                redundantList.add(mutableListOf())
                redundantList[redundantList.size - 1].addAll(service.findByNameContain(name))
            }
        }

        id?.let {
            redundantList.add(mutableListOf())
            redundantList[redundantList.size - 1].addAll(service.findById(id))
        }

        return redundantList.optimize()
    }
}