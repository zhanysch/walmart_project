package io.ubertechnologies.walmartproject.data.repository

import io.ubertechnologies.walmartproject.data.model.Country
import io.ubertechnologies.walmartproject.data.network.CountryApi

class CountryRepository(private val countryApi : CountryApi) {

    suspend fun getCountries() : List<Country>{
        return countryApi.getCountries()
    }
}