package com.formationandroid.demoappkotlin5.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.formationandroid.demoappkotlin5.R
import kotlin.random.Random

class SauvegardeActivity : AppCompatActivity()
{
	companion object
	{
		private const val CLE_DE1 = "de1"
		private const val CLE_DE2 = "de2"
		private const val CLE_DE3 = "de3"
	}

	private var de1 = 0
	private var de2 = 0
	private var de3 = 0

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_sauvegarde)

		if (savedInstanceState != null)
		{
			de1 = savedInstanceState.getInt(CLE_DE1)
			de2 = savedInstanceState.getInt(CLE_DE2)
			de3 = savedInstanceState.getInt(CLE_DE3)
		}
		else
		{
			de1 = Random.nextInt(1, 6)
			de2 = Random.nextInt(1, 6)
			de3 = Random.nextInt(1, 6)
		}

		val textViewDe1: TextView = findViewById(R.id.de1)
		val textViewDe2: TextView = findViewById(R.id.de2)
		val textViewDe3: TextView = findViewById(R.id.de3)

		textViewDe1.text = de1.toString()
		textViewDe2.text = de2.toString()
		textViewDe3.text = de3.toString()
	}

	override fun onSaveInstanceState(outState: Bundle)
	{
		outState.putInt(CLE_DE1, de1)
		outState.putInt(CLE_DE2, de2)
		outState.putInt(CLE_DE3, de3)
		super.onSaveInstanceState(outState)
	}
}