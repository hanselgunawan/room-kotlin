package com.hanseltritama.roomkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hanseltritama.roomkotlin.db.Address
import com.hanseltritama.roomkotlin.db.RoomAppDB
import com.hanseltritama.roomkotlin.db.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
    }

    fun setupUI() {
        submit_button.setOnClickListener {
            val name = user_profile_name.text.toString()
            val phone = user_profile_phone.text.toString()
            val email = user_profile_email.text.toString()
            val address = user_address_name.text.toString()
            val city = user_address_city.text.toString()
            val state = user_address_state.text.toString()
            val zip = user_address_zip.text.toString()

            val userDao = RoomAppDB.getAppDatabase(this)?.userDao()
            val userEntity = UserEntity(0, name, phone, email)
            val id = userDao?.insertUser(userEntity)
            val addressEntity = Address(0, id!!.toInt(), address, city, state, zip)
            userDao?.insertAddress(addressEntity)

            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
            finish()
        }
    }
}