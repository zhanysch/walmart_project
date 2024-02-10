package io.ubertechnologies.walmartproject.data.network

import io.ubertechnologies.walmartproject.data.model.Country
import retrofit2.http.GET

interface CountryApi {
    @GET("countries.json")
    suspend fun getCountries(): List<Country>
}