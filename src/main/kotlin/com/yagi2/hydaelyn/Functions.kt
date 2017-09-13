package com.yagi2.hydaelyn

fun <T> MutableList<MutableList<T>>.optimize(): MutableList<T> {
    val result = mutableListOf<T>()

    this.forEach {
        it.forEach { element ->
            if (all { it.contains(element) } && result.contains(element).not()) {
                result.add(element)
            }
        }
    }

    return result
}