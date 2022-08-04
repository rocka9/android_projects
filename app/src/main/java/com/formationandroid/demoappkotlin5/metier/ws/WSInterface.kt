package com.formationandroid.demoappkotlin5.metier.ws

import com.formationandroid.demoappkotlin5.bo.Planete
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WSInterface
{
	@GET("api/planets/1")
	fun getPlanete1(): Call<Planete>

	@GET("api/planets/{id}")
	fun getPlanete(@Path("id") id: Int): Call<Planete>

	@GET("api/planets/{id}")
	suspend fun getPlaneteSync(@Path("id") id: Int): Planete
}