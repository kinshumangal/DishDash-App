package com.kinshu.dishdash.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kinshu.dishdash.databinding.CartItemsBinding

class CardAdapter(
    private val cartItems: MutableList<String>,
    private val cartPrice: MutableList<String>,
    private var cartImage: MutableList<Int>
) : RecyclerView.Adapter<CardAdapter.CartViewHolder>() {

    private val itemQuantity = IntArray(cartItems.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(private val binding: CartItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantity[position]
                cartDishName.text = cartItems[position]
                cartItemPrice.text = cartPrice[position]
                cartDishImage.setImageResource(cartImage[position])
                numberOfItem.text = quantity.toString()

                removeButton.setOnClickListener {
                    decreaseQuantity(position)
                }
                addButton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(itemPosition)
                    }
                }
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantity[position] > 1) {
                itemQuantity[position]--
                binding.numberOfItem.text = itemQuantity[position].toString()
            }
        }

        private fun increaseQuantity(position: Int) {
            itemQuantity[position]++
            binding.numberOfItem.text = itemQuantity[position].toString()
        }

        private fun deleteItem(position: Int) {
            cartItems.removeAt(position)
            cartPrice.removeAt(position)
            cartImage.removeAt(position)
            itemQuantity[position] = 1
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
        }
    }
}