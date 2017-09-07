package com.yagi2.hydaelyn.repository.item

import com.yagi2.hydaelyn.model.entity.item.ItemCategory
import org.springframework.data.jpa.repository.JpaRepository

interface ItemCategoryRepository : JpaRepository<ItemCategory, Int> {
    fun findById(id: Int): List<ItemCategory>

    fun findByName(name: String): List<ItemCategory>
    fun findByNameContainsOrderByIdAsc(name: String): List<ItemCategory>
}