package com.yagi2.hydaelyn.service.item

import com.yagi2.hydaelyn.model.entity.item.Item
import com.yagi2.hydaelyn.repository.item.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ItemService {

    @Autowired
    lateinit var repository: ItemRepository

    fun selectAll(): List<Item> = repository.findAll(Sort(Sort.Direction.ASC, "id"))

    fun findByName(name: String): List<Item> = repository.findByName(name)
    fun findByNameContains(name: String): List<Item> = repository.findByNameContainsOrderByIdAsc(name)
}