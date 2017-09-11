package com.yagi2.hydaelyn.repository.item

import com.yagi2.hydaelyn.model.entity.item.ItemCategoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ItemCategoryRepository : JpaRepository<ItemCategoryEntity, Int> {
    fun findById(id: Int): List<ItemCategoryEntity>

    fun findByName(name: String): List<ItemCategoryEntity>
    fun findByNameContainsOrderByIdAsc(name: String): List<ItemCategoryEntity>
}