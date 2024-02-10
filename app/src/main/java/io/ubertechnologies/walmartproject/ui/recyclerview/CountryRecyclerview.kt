package io.ubertechnologies.walmartproject.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.ubertechnologies.walmartproject.data.model.Country
import io.ubertechnologies.walmartproject.databinding.CountryItemsBinding

class CountryRecyclerview : ListAdapter<Country , CountryViewHolder>(CountryDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CountryItemsBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)
    }
}

class CountryViewHolder(private val binding: CountryItemsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(country: Country) {
        binding.apply {
           countriesName.text = country.name
            countriesRegion.text = "${country.region}, ${country.code}"
            countriesCapital.text = country.capital
        }
    }
}

class CountryDiffUtil : DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.code == newItem.code &&
        oldItem.name == newItem.name &&
        oldItem.region == newItem.region&&
        oldItem.capital == newItem.capital
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }
}