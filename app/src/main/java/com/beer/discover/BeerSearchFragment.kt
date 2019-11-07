package com.beer.discover

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.system.Os.bind
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.EditText
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
        model.addListener(BeerFragmentModel.ChangeEvent.BEER_LIST_UPDATED, updateBeerList)

    }
    private val updateBeerList = EventListener { bindViews() }

    private fun bindViews() {
        val beerList = view!!.findViewById<View>(R.id.beerList) as RecyclerView
        beerList.layoutManager = LinearLayoutManager(context)
        val searchBox = view!!.findViewById<View>(R.id.searchBar) as EditText
        beerList.layoutManager = LinearLayoutManager(context)
        val searchButton = view!!.findViewById<View>(R.id.searchButton)
        beerList.layoutManager = LinearLayoutManager(context)
        searchButton.setOnClickListener(View.OnClickListener {
            //button was clicked to execute search
        })
        searchBox.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewListener.onSearchTextUpdated(p0.toString())
            }
        })
    }
}