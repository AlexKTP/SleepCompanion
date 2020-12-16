package com.example.sleepcompanion.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object{

        //Volatile Annotation make this variable visible from another threads
        @Volatile
        private var INSTANCE : UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase{

            //Check if an instance of a DB is already created
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance;
            }

            // If there is no DB instance, ROOM helps to create one by its built-in method database.builder
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, UserDatabase::class.java, "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}