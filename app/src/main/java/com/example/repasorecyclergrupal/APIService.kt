package com.example.repasorecyclergrupal

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
//no es requerida
interface APIService {
    @GET
    fun getCharacterByName(@Url url:String): Call<Licor>
}