package com.yagi2.hydaelyn.controller.item

import com.yagi2.hydaelyn.model.entity.item.Item
import com.yagi2.hydaelyn.service.item.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/item")
class ItemController {

    @Autowired
    lateinit var service: ItemService

    @RequestMapping(value = "/all", method = arrayOf(RequestMethod.GET))
    fun selectAll(): List<Item> = service.selectAll()

    @RequestMapping(value = "/search", method = arrayOf(RequestMethod.GET))
    fun search(@RequestParam(value = "name", required = false) name: String?): List<Item> {

        val redundantList = mutableListOf<MutableList<Item>>()

        name?.let {
            if (name.isNotBlank()) {
                redundantList.add(mutableListOf())
                redundantList[redundantList.size - 1].addAll(service.findByNameContains(name))
            }
        }

        val result = mutableListOf<Item>()

        redundantList.forEach {
            it.forEach { item ->
                if (redundantList.all { it.contains(item) } && result.contains(item).not()) {
                    result.add(item)
                }
            }
        }

        return result
    }
}