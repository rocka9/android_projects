package com.formationandroid.demoappkotlin5.metier.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
class CourseDTO(
	@PrimaryKey(autoGenerate = true)
	val courseId: Long = 0,
	val intitule: String? = null,
	val achete: Boolean = false,
	val prix: Float = 0F)
