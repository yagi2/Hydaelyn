package com.yagi2.hydaelyn.model.entity

import javax.persistence.*

@Entity
@Table(name = "item")
data class Item(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "name")
        val name: String
)