package com.formationandroid.demoappkotlin5.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.formationandroid.demoappkotlin5.R
import kotlin.random.Random

class PreferencesActivity : AppCompatActivity()
{
	companion object
	{
		private const val SCORE = "score"
	}

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_preferences)

		// lecture :
		val preferences = PreferenceManager.getDefaultSharedPreferences(this)
		val score = preferences.getInt(SCORE, 0)

		Toast.makeText(this, "score récupéré : $score", Toast.LENGTH_LONG).show()
	}

	fun clicJouer(view: View)
	{
		val score = Random.nextInt(1, 100)
		Toast.makeText(this, "score : $score", Toast.LENGTH_LONG).show()

		val preferences = PreferenceManager.getDefaultSharedPreferences(this)
		val editor = preferences.edit()
		editor.putInt(SCORE, score)
		editor.apply()
	}
}