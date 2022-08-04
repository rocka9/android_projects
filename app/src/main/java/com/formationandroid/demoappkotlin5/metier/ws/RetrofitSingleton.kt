package com.formationandroid.demoappkotlin5.metier.ws

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton
{

	val retrofit: Retrofit = Retrofit.Builder()
		.baseUrl("https://swapi.dev/")
		.addConverterFactory(GsonConverterFactory.create())
		.build()

}