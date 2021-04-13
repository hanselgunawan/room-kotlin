package com.hanseltritama.roomkotlin.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserProfileDao {

    @Query("SELECT * FROM user ORDER BY id desc")
    fun getUserData(): List<UserEntity>?

    @Insert
    fun insertUser(user: UserEntity): Long

    @Insert
    fun insertAddress(user: Address)

    @Query("SELECT * FROM user INNER JOIN address ON user.id = address.user_id")
    fun getAllUserWithAddress(): List<UserWithAddress>?

}