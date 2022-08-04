package com.formationandroid.demoappkotlin5.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.formationandroid.demoappkotlin5.R
import com.formationandroid.demoappkotlin5.bo.Contact

class DetailActivity : AppCompatActivity()
{
	companion object
	{
		const val CLE_PARAMETRE = "parametre"
	}

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)

		val contact: Contact? = intent.getParcelableExtra(CLE_PARAMETRE)
		Toast.makeText(this, contact.toString(), Toast.LENGTH_LONG).show()
	}
}