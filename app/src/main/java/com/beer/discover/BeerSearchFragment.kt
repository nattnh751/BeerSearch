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
import kotlinx.android.synthetic.main.beer_fragment.*

class BeerSearchFragment : Fragment() {
    lateinit var model: BeerFragmentModel
    lateinit var viewListener: BeerFragmentListener
    lateinit var beerAdapter: BeerListAdapter
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
    private val updateBeerList = EventListener {
        if(beerList != null && beerList.adapter != null) {
            (beerList.adapter as BeerListAdapter).setNewItems(createListItemsFromModel())
        } else {
            bindViews()
        }
    }

    private fun bindViews() {
        val beerList = view!!.findViewById<View>(R.id.beerList) as RecyclerView
        beerList.layoutManager = LinearLayoutManager(context)
        val searchBox = view!!.findViewById<View>(R.id.searchBar) as EditText
        beerList.layoutManager = LinearLayoutManager(context)
        val searchButton = view!!.findViewById<View>(R.id.searchButton)
        beerList.layoutManager = LinearLayoutManager(context)
        searchButton.setOnClickListener(View.OnClickListener {
            viewListener.onSearchTextUpdated(searchBox.text.toString())
        })
        searchBox.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(newTextChanged: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //TODO clear list when text is empty, also perform search when text has changed instead of button press
            }
        })
        beerList.adapter = activity?.let { BeerListAdapter(createListItemsFromModel(), it) };
    }

    private fun createListItemsFromModel(): List<BeerItemListResource> {
        var beerlistitems = arrayListOf<BeerItemListResource>();
        for (beir in this.model.beers) {
            //TODO add image when it is available to list item
            beerlistitems.add(BeerItemListResource(beir.name,beir.description))
        }
        return beerlistitems
    }
}

class BeerItemListResource(val title: String, val descriptions: String) {

}
