package com.kinshu.dishdash.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.kinshu.dishdash.R
import com.kinshu.dishdash.adapter.MenuAdapter
import com.kinshu.dishdash.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val dishNames =
        listOf("Poha", "Chai", "Kachori", "Dal Bati", "Shahi Thali", "Aloo Parata", "Rasmalai")
    private val dishPrices = listOf("₹25", "₹18", "₹27", "₹230", "₹175", "₹150", "₹48")
    private val dishImages = listOf(
        R.drawable.indori_poha,
        R.drawable.chai,
        R.drawable.raj_kachori,
        R.drawable.dal_bati,
        R.drawable.shahi_thali,
        R.drawable.allo_paratha,
        R.drawable.rasmalai
    )

    private val filteredMenuDishNames = mutableListOf<String>()
    private val filteredMenuDishPrices = mutableListOf<String>()
    private val filteredMenuDishImages = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filteredMenuDishNames, filteredMenuDishPrices, filteredMenuDishImages)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //Setup for Search view
        setupSearchView()

        //Show all menu items
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuDishNames.clear()
        filteredMenuDishPrices.clear()
        filteredMenuDishImages.clear()

        filteredMenuDishNames.addAll(dishNames)
        filteredMenuDishPrices.addAll(dishPrices)
        filteredMenuDishImages.addAll(dishImages)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuDishNames.clear()
        filteredMenuDishPrices.clear()
        filteredMenuDishImages.clear()

        dishNames.forEachIndexed { index, dishName ->
            if (dishName.contains(query, ignoreCase = true)) {
                filteredMenuDishNames.add(dishName)
                filteredMenuDishPrices.add(dishPrices[index])
                filteredMenuDishImages.add(dishImages[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object
}