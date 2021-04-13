package com.hanseltritama.roomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hanseltritama.roomkotlin.db.RoomAppDB
import com.hanseltritama.roomkotlin.db.UserWithAddress
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Retrieve Data
        val userDao = RoomAppDB.getAppDatabase(this)?.userDao()
        val userWithAddressList: List<UserWithAddress>? = userDao?.getAllUserWithAddress()

        userWithAddressList?.forEach {
            profile_name.append("Name: ${it.name}\n")
            profile_phone.append("Phone: ${it.phone}\n")
            profile_email.append("Email: ${it.email}\n")
            profile_address.append("Address: ${it.address}\n")
            profile_address_city.append("City: ${it.city}\n")
            profile_address_state.append("Name: ${it.state}\n")
            profile_address_zip.append("Name: ${it.zip}\n")
        }
    }
}