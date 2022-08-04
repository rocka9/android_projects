package com.formationandroid.demoappkotlin5.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.formationandroid.demoappkotlin5.R

private const val TAG = "CycleVieActivity"

class CycleVieActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_cycle_vie)

		Log.i(TAG, "onCreate")
	}

	override fun onStart()
	{
		super.onStart()
		Log.d(TAG, "onStart")
	}

	override fun onResume()
	{
		super.onResume()
		Log.d(TAG, "onResume")
	}

	override fun onPause()
	{
		super.onPause()
		Log.d(TAG, "onPause")
	}

	override fun onStop()
	{
		super.onStop()
		Log.d(TAG, "onStop")
	}

	override fun onDestroy()
	{
		super.onDestroy()
		Log.w(TAG, "onDestroy")
	}
}