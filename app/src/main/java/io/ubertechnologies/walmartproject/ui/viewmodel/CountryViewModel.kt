package io.ubertechnologies.walmartproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ubertechnologies.walmartproject.data.model.Country
import io.ubertechnologies.walmartproject.data.repository.CountryRepository
import kotlinx.coroutines.launch

class CountryViewModel(private val repo : CountryRepository) : ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> get() = _countries

    init {
        viewModelScope.launch {
            try {
                _countries.value = repo.getCountries()
            } catch (e: Exception) {
                Log.d("error","error")
            }
        }
    }

}