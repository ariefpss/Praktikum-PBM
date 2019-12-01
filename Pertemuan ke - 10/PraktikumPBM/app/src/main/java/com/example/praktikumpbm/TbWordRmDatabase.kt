package com.example.praktikumpbm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(TbWord::class), version = 1, exportSchema = false)
public abstract class TbWordRmDatabase : RoomDatabase() {

    abstract fun tbwordDao() : TbWordDAO

    private class WordDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.tbwordDao())
                }
            }
        }

        suspend fun populateDatabase(tbwordDao: TbWordDAO) {
            // Delete all content here.
            tbwordDao.deleteAll()

            // Add sample words.
            var tbword = TbWord("Hello")
            tbwordDao.insert(tbword)
            tbword = TbWord("World!")
            tbwordDao.insert((tbword))
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: TbWordRmDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): TbWordRmDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TbWordRmDatabase::class.java,"word_database"
                ).addCallback(WordDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}