package com.kinshu.dishdash.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kinshu.dishdash.R
import com.kinshu.dishdash.adapter.CardAdapter
import com.kinshu.dishdash.databinding.FragmentCartBinding


class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartDishNames = listOf("Rasmalai", "Kachori", "Poha", "Chai")
        val cartDishPrices = listOf("₹48", "₹27", "₹23", "₹18")
        val cartDishImages = listOf(
            R.drawable.rasmalai,
            R.drawable.raj_kachori,
            R.drawable.indori_poha,
            R.drawable.chai
        )
        val cartAdapter = CardAdapter(
            ArrayList(cartDishNames),
            ArrayList(cartDishPrices),
            ArrayList(cartDishImages)
        )
        binding.cardRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cardRecyclerView.adapter = cartAdapter
        return binding.root
    }

    companion object
}