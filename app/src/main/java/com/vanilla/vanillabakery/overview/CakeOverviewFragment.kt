package com.vanilla.vanillabakery.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.vanilla.vanillabakery.R
import com.vanilla.vanillabakery.repository.VanillaRepository


class CakeOverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = CakeListAdapter()
        VanillaRepository().getCakesByCategory("cream").observe(viewLifecycleOwner , Observer {
            it.onSuccess {
                adapter.submitList(it)
            }
            it.onFailure {  }
        })



        val view = inflater.inflate(R.layout.fragment_cake_overview, container, false)
        view.findViewById<RecyclerView>(R.id.rv_cakes).adapter = adapter

        return view
    }

}