package com.beer.discover

import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeerListViewHolder() : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var countryName: TextView
    var countryPhoto: ImageView
    var layout: RelativeLayout

    init {
        itemView.setOnClickListener(this)
        countryName = itemView.findViewById(R.id.tvMediaName)
        countryPhoto = itemView.findViewById(R.id.ivMediaTileThumbnail)
        layout = itemView.findViewById(R.id.mediaTileLayout)
    }

    override fun onClick(view: View) {
        //Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        viewListener.onContentSelected(categoryList[position])
    }


}