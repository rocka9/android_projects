package com.formationandroid.demoappkotlin5.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.formationandroid.demoappkotlin5.R
import com.formationandroid.demoappkotlin5.adapters.CoursesAdapter
import com.formationandroid.demoappkotlin5.metier.bdd.AppDatabaseHelper
import com.formationandroid.demoappkotlin5.metier.dto.CourseDTO

class ListeActivity : AppCompatActivity(), View.OnClickListener
{
	private lateinit var coursesAdapter: CoursesAdapter
	private lateinit var recyclerView: RecyclerView


	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_liste)

		// liste :
		recyclerView = findViewById(R.id.liste_courses)

		// à ajouter pour de meilleures performances :
		recyclerView.setHasFixedSize(true)

		// layout manager, décrivant comment les items sont disposés :
		recyclerView.layoutManager = LinearLayoutManager(this)

		// contenu :
		val listeCourseDTO: List<CourseDTO> = AppDatabaseHelper.getDatabase(this).getCoursesDAO().getListeCourses()

		// adapter :
		coursesAdapter = CoursesAdapter(listeCourseDTO)
		recyclerView.adapter = coursesAdapter

		// listener bouton ok :
		val boutonOK: AppCompatButton = findViewById(R.id.bouton_valider)
		boutonOK.setOnClickListener(this)
	}

	override fun onClick(view: View)
	{
		// nouvelle course :
		val editTextCourse: EditText = findViewById(R.id.course)
		val saisie = editTextCourse.text.toString()
		val courseDTO = CourseDTO(0, saisie, false, 3F)

		// ajout :
		AppDatabaseHelper.getDatabase(this).getCoursesDAO().insert(courseDTO)
		val listeCourseDTO: List<CourseDTO> = AppDatabaseHelper.getDatabase(this).getCoursesDAO().getListeCourses()
		coursesAdapter.actualiserCourses(listeCourseDTO)

		// finalisation :
		editTextCourse.setText("")
		recyclerView.smoothScrollToPosition(0)
	}
}