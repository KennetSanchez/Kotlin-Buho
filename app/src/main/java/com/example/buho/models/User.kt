package com.example.buho.models

import java.io.Serializable


data class User(
    var id:String = "",
    var name:String = "",
    var email:String = "",
    ) : Serializable{
    override fun toString(): String {
        return name
    }

}