package com.hanseltritama.roomkotlin.db

import androidx.room.*

@Entity(tableName = "user")
data class UserEntity (
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "phone") val phone: String,
        @ColumnInfo(name = "email") val email: String
)

@Entity(
        tableName = "address",
        foreignKeys = [ForeignKey(entity = UserEntity::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("user_id"),
                onDelete = ForeignKey.CASCADE)],
        indices = [Index("user_id")]
)
data class Address(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "address_id") val address_id: Int,
        @ColumnInfo(name = "user_id") val id: Int,
        @ColumnInfo(name = "address") val address: String,
        @ColumnInfo(name = "city") val city: String,
        @ColumnInfo(name = "state") val state: String,
        @ColumnInfo(name = "zip") val zip: String
)