package com.kinshu.dishdash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kinshu.dishdash.adapter.MenuAdapter
import com.kinshu.dishdash.databinding.FragmentMenuBottomSheetBinding

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        val menuDishNames = listOf("Rasmalai", "Kachori", "Poha", "Chai")
        val menuDishPrices = listOf("₹48", "₹27", "₹23", "₹18")
        val menuDishImages = listOf(
            R.drawable.rasmalai,
            R.drawable.raj_kachori,
            R.drawable.indori_poha,
            R.drawable.chai
        )
        val menuAdapter = MenuAdapter(
            ArrayList(menuDishNames),
            ArrayList(menuDishPrices),
            ArrayList(menuDishImages)
        )

        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = menuAdapter

        return binding.root
    }

    companion object
}