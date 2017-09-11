package com.yagi2.hydaelyn.service.item

import com.yagi2.hydaelyn.model.entity.item.ItemCategoryEntity
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

    fun selectAll(): List<ItemCategoryEntity> = repository.findAll(Sort(Sort.Direction.ASC, "id"))

    fun findById(id: Int): List<ItemCategoryEntity> = repository.findById(id)

    fun findByName(name: String): List<ItemCategoryEntity> = repository.findByName(name)
    fun findByNameContains(name: String): List<ItemCategoryEntity> = repository.findByNameContainsOrderByIdAsc(name)
}