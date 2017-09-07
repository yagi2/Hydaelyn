package com.yagi2.hydaelyn.service.item

import com.yagi2.hydaelyn.model.entity.item.ItemCategory
import com.yagi2.hydaelyn.repository.item.ItemCategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ItemCategoryService {

    @Autowired
    lateinit var repository: ItemCategoryRepository

    fun selectAll(): List<ItemCategory> = repository.findAll(Sort(Sort.Direction.ASC, "id"))

    fun findById(id: Int): List<ItemCategory> = repository.findById(id)

    fun findByName(name: String): List<ItemCategory> = repository.findByName(name)
    fun findByNameContains(name: String): List<ItemCategory> = repository.findByNameContainsOrderByIdAsc(name)
}