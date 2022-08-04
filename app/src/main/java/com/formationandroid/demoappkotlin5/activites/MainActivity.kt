package com.formationandroid.demoappkotlin5.activites

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.formationandroid.demoappkotlin5.R

class MainActivity : AppCompatActivity()
{
	companion object
	{
		private const val TAG = "MainActivity"
	}

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	fun clicValider(view: View)
	{
		val editTextPassword: EditText = findViewById(R.id.password)
		val saisiePassword: String = editTextPassword.text.toString()
		Log.d(TAG, "clicValider: $saisiePassword")
		Log.d(TAG, "clicValider: ${getString(R.string.app_name)}")
	}

}