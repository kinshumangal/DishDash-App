package com.kinshu.dishdash.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kinshu.dishdash.databinding.BuyAgainNewItemBinding

class BuyAgainAdapter(
    private val buyAgainDishNames: ArrayList<String>,
    private val buyAgainDishPrices: ArrayList<String>,
    private val buyAgainDishImages: ArrayList<Int>
) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding =
            BuyAgainNewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BuyAgainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(
            buyAgainDishNames[position], buyAgainDishPrices[position], buyAgainDishImages[position]
        )
    }

    override fun getItemCount(): Int = buyAgainDishNames.size

    class BuyAgainViewHolder(private val binding: BuyAgainNewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dishName: String, dishPrice: String, dishImage: Int) {
            binding.buyAgainDishName.text = dishName
            binding.buyAgainDishPrice.text = dishPrice
            binding.buyAgainDishImage.setImageResource(dishImage)

        }
    }
}