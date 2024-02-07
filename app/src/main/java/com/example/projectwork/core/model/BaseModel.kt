package com.example.projectwork.core.model

abstract class BaseModel {

    companion object{
       const val TOP_HEADLINE=0
       const val EVERY_THINK=1  // тут пишешь то  не входть в баннер
    }

    abstract fun getType():Int
}