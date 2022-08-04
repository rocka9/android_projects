package com.formationandroid.demoappkotlin5.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.formationandroid.demoappkotlin5.R
import com.formationandroid.demoappkotlin5.bo.Planete
import com.formationandroid.demoappkotlin5.metier.ws.ReseauHelper
import com.formationandroid.demoappkotlin5.metier.ws.RetrofitSingleton
import com.formationandroid.demoappkotlin5.metier.ws.WSInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_retrofit)
	}

	fun clicAppelerWebservice(view: View)
	{
		// vérification connexion :
		if (!ReseauHelper.estConnecte(this))
		{
			Toast.makeText(this, "Aucune connexion internet", Toast.LENGTH_LONG).show()
			return
		}

		// appel synchrone :
		CoroutineScope(Dispatchers.IO).launch {

			val retrofit = RetrofitSingleton.retrofit.create(WSInterface::class.java)
			val planete = retrofit.getPlaneteSync(3)
			Log.i("TAG", "onResponse: $planete")
		}


		// appel :
//		val retrofit = RetrofitSingleton.retrofit.create(WSInterface::class.java)
//		val call = retrofit.getPlanete1()
//		call.enqueue(object : Callback<Planete>
//		{
//			override fun onResponse(call: Call<Planete>, response: Response<Planete>)
//			{
//				if (response.isSuccessful)
//				{
//					val planete = response.body()
//					Log.i("TAG", "onResponse: $planete")
//				}
//			}
//
//			override fun onFailure(call: Call<Planete>, t: Throwable)
//			{
//				Log.e("TAG", "onFailure : $t", t)
//			}
//		})
	}
}