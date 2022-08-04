package com.formationandroid.demoappkotlin5.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.formationandroid.demoappkotlin5.R

class EvenementActivity : AppCompatActivity(), View.OnClickListener
{
	private lateinit var bouton: Button

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_evenement)

		bouton = findViewById(R.id.bouton)
		bouton.setOnClickListener(this)
//		bouton.setOnClickListener {
//			Toast.makeText(this, "clic bouton", Toast.LENGTH_SHORT).show()
//		}
		bouton.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
			Log.d("TAG", "onCreate largeur : ${bouton.width}")
		}
	}

	override fun onClick(view: View)
	{
		if (view === bouton)
		{
			Toast.makeText(this, "clic bouton", Toast.LENGTH_SHORT).show()
		}
	}
}