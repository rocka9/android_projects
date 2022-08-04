package com.formationandroid.demoappkotlin5.metier.bdd

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class AppDatabaseHelper(context: Context)
{
	// Bloc de code "static" :
	companion object
	{
		// Migrations :
		val MIGRATION_1_2 = object : Migration(1, 2)
		{
			override fun migrate(database: SupportSQLiteDatabase)
			{
				database.execSQL(" ALTER TABLE courses ADD COLUMN prix REAL NOT NULL DEFAULT 0 ")
			}
		}

		// Helper :
		private lateinit var databaseHelper: AppDatabaseHelper

		// Getter instance :
		fun getDatabase(context: Context): AppDatabase
		{
			if (!::databaseHelper.isInitialized)
			{
				databaseHelper = AppDatabaseHelper(context)
			}
			return databaseHelper.database
		}
	}

	// Base de données :
	val database: AppDatabase = Room
		.databaseBuilder(context.applicationContext, AppDatabase::class.java, "courses.db")
		.addMigrations(MIGRATION_1_2)
		.allowMainThreadQueries()
		.build()
}