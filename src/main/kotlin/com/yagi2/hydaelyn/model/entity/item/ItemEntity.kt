package com.yagi2.hydaelyn.model.entity.item

import javax.persistence.*

@Entity
@Table(name = "item")
data class ItemEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "name")
        val name: String,

        @Column(name = "can_take")
        val canTake: Boolean
)