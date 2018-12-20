package com.yakov.weber.businesscart.model

import com.yakov.weber.businesscart.entity.BusinessCard

object MockData {
    private val list:MutableList<BusinessCard> = mutableListOf()
    fun newInstance():MutableList<BusinessCard>{
        list.clear()
        for (i in 0..100){
            list.add(            BusinessCard("Яков $i","android developer","www.yakow.weber.com","java@gmail.com","8(921)007-13-85",
                "ул. Маршала Баграмяна, 34")
            )
        }
        return list
    }
}