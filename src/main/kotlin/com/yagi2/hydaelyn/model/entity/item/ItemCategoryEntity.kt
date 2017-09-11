package com.yagi2.hydaelyn.model.entity.item

import javax.persistence.*

@Entity
@Table(name = "item_category")
data class ItemCategoryEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "name")
        val name: String
)