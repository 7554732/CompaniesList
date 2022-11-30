package com.fomichev.companieslist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CompanyItem::class], version = 1, exportSchema = false)
abstract class CompaniesDatabase : RoomDatabase() {

    abstract val companiesDao: CompaniesDao

    companion object {

        @Volatile
        private var INSTANCE: CompaniesDatabase? = null

        fun getInstance(context: Context): CompaniesDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CompaniesDatabase::class.java,
                        "companies_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}