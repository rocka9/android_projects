package com.formationandroid.demoappkotlin5.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.formationandroid.demoappkotlin5.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_coroutine)
	}

	fun clicLancerCoroutine(view: View)
	{
		val bouton: Button = findViewById(R.id.bouton)

		Log.i("TAG", "clicLancerCoroutine: début")
		CoroutineScope(Dispatchers.Default).launch {

			for (a in 0..500_000_000)
			{
				if (a % 10_000_000 == 0)
				{
					Log.d("TAG", "clicLancerCoroutine: $a")
					withContext(Dispatchers.Main) {
						bouton.text = a.toString()
					}
				}
			}
			withContext(Dispatchers.Main) {
				bouton.text = "FIN"
			}
		}
		Log.i("TAG", "clicLancerCoroutine: fin")
	}
}