package com.formationandroid.demoappkotlin5.metier.bdd

import androidx.room.Database
import androidx.room.RoomDatabase
import com.formationandroid.demoappkotlin5.metier.dao.CoursesDAO
import com.formationandroid.demoappkotlin5.metier.dto.CourseDTO

@Database(entities = [CourseDTO::class], version = 2)
abstract class AppDatabase : RoomDatabase()
{
	abstract fun getCoursesDAO(): CoursesDAO
}
