package com.kinshu.dishdash.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kinshu.dishdash.R
import com.kinshu.dishdash.adapter.BuyAgainAdapter
import com.kinshu.dishdash.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val buyAgainDishNames = arrayListOf("Rasmalai", "Kachori", "Poha", "Chai")
        val buyAgainDishPrices = arrayListOf("₹48", "₹27", "₹23", "₹18")
        val buyAgainDishImages = arrayListOf(
            R.drawable.rasmalai,
            R.drawable.raj_kachori,
            R.drawable.indori_poha,
            R.drawable.chai
        )
        buyAgainAdapter = BuyAgainAdapter(buyAgainDishNames, buyAgainDishPrices, buyAgainDishImages)
        binding.buyAgainRecyclerView.adapter = buyAgainAdapter
        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object
}
