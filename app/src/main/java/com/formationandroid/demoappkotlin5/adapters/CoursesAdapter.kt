package com.formationandroid.demoappkotlin5.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.formationandroid.demoappkotlin5.R
import com.formationandroid.demoappkotlin5.metier.bdd.AppDatabaseHelper
import com.formationandroid.demoappkotlin5.metier.dto.CourseDTO

class CoursesAdapter(private var listeCourseDTO: List<CourseDTO>) : RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>()
{

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder
	{
		val viewCourse = LayoutInflater
			.from(parent.context)
			.inflate(R.layout.item_course, parent, false)
		return CourseViewHolder(viewCourse)
	}

	override fun onBindViewHolder(holder: CourseViewHolder, position: Int)
	{
		holder.textViewLibelleCourse.text = listeCourseDTO[position].intitule
		holder.switchAcheteCourse.isChecked = listeCourseDTO[position].achete
		holder.textViewPrixCourse.text = "${listeCourseDTO[position].prix} euros"
	}

	override fun getItemCount(): Int = listeCourseDTO.size

	fun actualiserCourses(listeCourseDTO: List<CourseDTO>)
	{
		this.listeCourseDTO = listeCourseDTO
		notifyDataSetChanged()
	}

	// Viewholder :
	inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
	{
		val textViewLibelleCourse: TextView = itemView.findViewById(R.id.libelle_course)
		val switchAcheteCourse: SwitchCompat = itemView.findViewById(R.id.achete_course)
		val textViewPrixCourse: TextView = itemView.findViewById(R.id.prix_course)
		val boutonSupprimerCourse: ImageButton = itemView.findViewById(R.id.supprimer_course)

		init
		{
			itemView.setOnClickListener {
				val courseDTO = listeCourseDTO[adapterPosition]
				Toast.makeText(itemView.context, courseDTO.toString(), Toast.LENGTH_LONG).show()
			}
			boutonSupprimerCourse.setOnClickListener {
				val courseDTO = listeCourseDTO[adapterPosition]
				AppDatabaseHelper.getDatabase(itemView.context).getCoursesDAO().delete(courseDTO)
				val listeCourseDTO: List<CourseDTO> = AppDatabaseHelper.getDatabase(itemView.context).getCoursesDAO().getListeCourses()
				actualiserCourses(listeCourseDTO)
			}
		}
	}

}