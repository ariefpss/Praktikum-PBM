package com.example.praktikumpbm.api

import com.example.praktikumpbm.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface PhotosApi {
    @GET("photos")
    fun getPhotos(): Single<List<Photo>>
}