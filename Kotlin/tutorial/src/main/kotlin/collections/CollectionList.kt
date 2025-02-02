package org.ruu.collections

class CollectionList<T> {

    var newList = mutableListOf<T>()

    val normalList = mutableListOf<T>()

    fun initMutableList(){

    }

    fun initList(list: MutableList<T> ): List<MutableList<T>> {
        return listOf(list)
    }
}