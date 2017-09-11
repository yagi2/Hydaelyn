package com.yagi2.hydaelyn.repository.item

import com.yagi2.hydaelyn.model.entity.item.ItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<ItemEntity, Int> {
    fun findByName(name: String): List<ItemEntity>
    fun findByNameContainsOrderByIdAsc(name: String): List<ItemEntity>

    fun findByCanTakeOrderByIdAsc(canTake: Boolean): List<ItemEntity>
}