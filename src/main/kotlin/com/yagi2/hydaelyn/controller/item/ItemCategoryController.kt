package com.yagi2.hydaelyn.controller.item

import com.yagi2.hydaelyn.model.entity.item.ItemCategoryEntity
import com.yagi2.hydaelyn.service.item.ItemCategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/itemcategory")
class ItemCategoryController {

    @Autowired
    lateinit var service: ItemCategoryService

    @RequestMapping(value = "/all", method = arrayOf(RequestMethod.GET))
    fun selectAll(): List<ItemCategoryEntity> = service.selectAll()

    @RequestMapping(value = "/search", method = arrayOf(RequestMethod.GET))
    fun search(@RequestParam(value = "name", required = false) name: String?,
               @RequestParam(value = "id", required = false) id: Int?): List<ItemCategoryEntity> {

        val redundantList = mutableListOf<MutableList<ItemCategoryEntity>>()

        name?.let {
            if (name.isNotBlank()) {
                redundantList.add(mutableListOf())
                redundantList[redundantList.size - 1].addAll(service.findByNameContains(name))
            }
        }

        id?.let {
            redundantList.add(mutableListOf())
            redundantList[redundantList.size - 1].addAll(service.findById(id))
        }

        val result = mutableListOf<ItemCategoryEntity>()

        redundantList.forEach {
            it.forEach { itemCategory ->
                if (redundantList.all { it.contains(itemCategory) } && result.contains(itemCategory).not()) {
                    result.add(itemCategory)
                }
            }
        }

        return result
    }
}