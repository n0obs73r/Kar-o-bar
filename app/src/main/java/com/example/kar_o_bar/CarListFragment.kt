package com.example.kar_o_bar

import android.R
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.Nullable
import androidx.fragment.app.ListFragment

class CarListFragment : ListFragment() {
    var activity: ItemSelected? = null

    interface ItemSelected {
        fun onItemSelected(index: Int)
    }

    private fun ListFrag() {
        // Required empty public constructor
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as ItemSelected
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val data = ArrayList<String>()
        data.add("1. BMW")
        data.add("2. Mercedes")
        data.add("3. Alfa Romeo")
        data.add("4. Volswagon")
        data.add("4. Audi")
        listAdapter = ArrayAdapter(requireActivity(), R.layout.simple_list_item_1, data)


    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        activity?.onItemSelected(position)
    }
}