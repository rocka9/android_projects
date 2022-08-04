package com.formationandroid.demoappkotlin5.metier.dao

import androidx.room.*
import com.formationandroid.demoappkotlin5.metier.dto.CourseDTO

@Dao
abstract class CoursesDAO
{

	@Query("SELECT * FROM courses ORDER BY intitule ASC")
	abstract fun getListeCourses(): List<CourseDTO>

	@Query("SELECT COUNT(*) FROM courses WHERE intitule = :intitule")
	abstract fun countCoursesParIntitule(intitule: String): Long

	@Insert
	abstract fun insert(vararg courses: CourseDTO)

	@Update
	abstract fun update(vararg courses: CourseDTO)

	@Delete
	abstract fun delete(vararg courses: CourseDTO)

}