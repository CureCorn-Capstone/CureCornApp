package com.example.curecornapp.API

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService{
    @Multipart
    @POST("predict")
    fun uploadImage(
        @Part file: MultipartBody.Part
    ): Call<CornResponse>
}

data class CornResponse(
    @field:SerializedName("confidence")
    val confidence: Double? = null,

    @field:SerializedName("class")
    val jsonMemberClass: String? = null,
)

class ApiConfig{
    val baseUrl = "https://curecornapi-flask-afm43kqnba-uc.a.run.app/"

    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiService {
        return getRetrofit().create(ApiService::class.java)
    }
}