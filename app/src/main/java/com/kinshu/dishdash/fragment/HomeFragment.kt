package com.kinshu.dishdash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.kinshu.dishdash.MenuBottomSheetFragment

import com.kinshu.dishdash.R
import com.kinshu.dishdash.adapter.PopularAdapter
import com.kinshu.dishdash.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.viewAllMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager, "Test")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.food_facebook_cover, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.food_banner, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.food_banner1, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {

            }

            override fun onItemSelected(position: Int) {
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })

        val dishName =
            listOf("Poha", "Chai", "Kachori", "Dal Bati", "Shahi Thali", "Aloo Parata", "Rasmalai")
        val price = listOf("₹25", "₹18", "₹27", "₹230", "₹175", "₹150", "₹48")
        val dishImages = listOf(
            R.drawable.indori_poha,
            R.drawable.chai,
            R.drawable.raj_kachori,
            R.drawable.dal_bati,
            R.drawable.shahi_thali,
            R.drawable.allo_paratha,
            R.drawable.rasmalai
        )
        val adapter = PopularAdapter(dishName, price, dishImages)
        binding.populerReclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.populerReclerView.adapter = adapter
    }

    companion object
}
