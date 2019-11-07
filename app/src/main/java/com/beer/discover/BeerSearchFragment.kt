package com.beer.discover

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BeerSearchFragment : Fragment() {
    lateinit var model: BeerFragmentModel
    lateinit var viewListener: BeerFragmentListener

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.beer_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
    }
    private fun bindViews() {
        val beerList = view!!.findViewById<View>(R.id.beerList) as RecyclerView
        beerList.layoutManager = LinearLayoutManager(context)
//        val adapter = CategoryListAdapter(activity!!, getBeerListItems()!!,)
//        beerList.adapter = adapter
        }

    }
}