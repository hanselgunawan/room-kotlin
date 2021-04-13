package com.hanseltritama.roomkotlin.db

data class UserWithAddress(
    var id: String,
    var address_id: Int,
    var user_id: Int,
    var name: String,
    var phone: String,
    var email: String,
    var address: String,
    var city: String,
    var state: String,
    var zip: String
)
