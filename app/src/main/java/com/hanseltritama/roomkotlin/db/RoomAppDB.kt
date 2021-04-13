package com.hanseltritama.roomkotlin.db

import android.content.Context
import androidx.room.*

@Database(entities = [UserEntity::class, Address::class], version = 1, exportSchema = false)
abstract class RoomAppDB : RoomDatabase() {

    abstract fun userDao(): UserProfileDao?

    companion object {
        private var INSTANCE: RoomAppDB? = null

        fun getAppDatabase(context: Context): RoomAppDB? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<RoomAppDB>(
                    context.applicationContext, RoomAppDB::class.java, "demo_dp")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}