package com.beer.discover

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

public class BeerListAdapter(val items: List<BeerItemListResource>,val activity: Activity) : RecyclerView.Adapter<BeerListAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items.get(position)
        holder.title!!.text = item.title
        holder.description!!.text = item.descriptions
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(activity).inflate(R.layout.beer_list_item, parent, false))
    }
    inner class ViewHolder

    internal constructor(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var description: TextView? = view.findViewById(R.id.description)
        var title: TextView? = view.findViewById(R.id.title)
        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
    }
}
