package com.example.buho.models

import java.io.Serializable

data class MyActivityCardComponent (
    var title : String = "",
    var description: String = "",
    var state: String = "",
    var classroom: String = "",
    var schedule: String = "",
    var teacher: String = ""
): Serializable {}
