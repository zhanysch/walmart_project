package io.ubertechnologies.walmartproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.ubertechnologies.walmartproject.data.network.RetrofitBuilder
import io.ubertechnologies.walmartproject.data.repository.CountryRepository
import io.ubertechnologies.walmartproject.databinding.ActivityMainBinding
import io.ubertechnologies.walmartproject.ui.recyclerview.CountryRecyclerview
import io.ubertechnologies.walmartproject.ui.viewmodel.CountryViewModelFactory
import io.ubertechnologies.walmartproject.ui.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryViewModel: CountryViewModel
    private lateinit var countryAdapter: CountryRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        binding.recyclerCountry.adapter = countryAdapter

        val api = RetrofitBuilder.create()
        val repository = CountryRepository(api)
        countryViewModel = ViewModelProvider(this, CountryViewModelFactory(repository))
            .get(CountryViewModel::class.java)


        countryViewModel.countries.observe(this, Observer {
            countryAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        countryAdapter = CountryRecyclerview()
        binding.recyclerCountry.apply {
            adapter = countryAdapter
        }
    }
}