package com.yagi2.hydaelyn.model.usecase

import com.yagi2.hydaelyn.model.entity.item.ItemEntity

data class Item(
        val id: Int,
        val name: String
) {
    companion object {
        fun entityToUsecase(entity: ItemEntity): Item {
            return Item(
                    entity.id,
                    entity.name
            )
        }
    }
}