package com.yagi2.hydaelyn.repository

import com.yagi2.hydaelyn.model.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Int> {
    fun findByName(name: String): List<Item>
    fun findByNameContainsOrderByIdAsc(name: String): List<Item>
}