package com.yagi2.hydaelyn.service.item

import com.yagi2.hydaelyn.model.entity.item.ItemEntity
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

    fun selectAll(): List<ItemEntity> = repository.findAll(Sort(Sort.Direction.ASC, "id"))

    fun findByName(name: String): List<ItemEntity> = repository.findByName(name)
    fun findByNameContains(name: String): List<ItemEntity> = repository.findByNameContainsOrderByIdAsc(name)

    fun findByCanTakeItems(): List<ItemEntity> = repository.findByCanTakeOrderByIdAsc(true)
}