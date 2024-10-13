package com.kinshu.dishdash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kinshu.dishdash.R
import com.kinshu.dishdash.adapter.NotificationAdapter
import com.kinshu.dishdash.databinding.FragmentNotificationBottomBinding


class NotificationBottomFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false)

        val notifications = listOf(
            "Your Order has been Canceled Successfully",
            "Order has been taken by the driver",
            "Congrats! Your Order Placed"
        )
        val notificationsImages = listOf(
            R.drawable.sademoji,
            R.drawable.orderbike,
            R.drawable.correct
        )

        val adapter = NotificationAdapter(ArrayList(notifications), ArrayList(notificationsImages))
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter
        return binding.root
    }

    companion object
}