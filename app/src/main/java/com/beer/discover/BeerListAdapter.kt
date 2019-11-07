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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }
    inner class ViewHolder

    internal constructor(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

//        var ivHeader: ImageView? = view.findViewById(R.id.ivHeader)
//        var ivFooter: ImageView? = view.findViewById(R.id.ivFooter)
//        var title: TextView? = view.findViewById(R.id.tvCategoryText)
//        var ivSelected: ImageView? = view.findViewById(R.id.ivRightBorder)
//        var ivThumb: ImageView? = view.findViewById(R.id.ivThumb)
//        var ivArrow: ImageView? = view.findViewById(R.id.ivArrow)
//        var ivDownloaded: ImageView? = view.findViewById(R.id.ivDownloaded)
//        var ivCategoryOptions: ImageView? = view.findViewById(R.id.ivCategoryOptions)
//        var ivDelete: ImageView? = view.findViewById(R.id.ivDelete)
//        var ivNewTag: ImageView? = view.findViewById(R.id.highlight_indicator)
//        var ivNewTagContainer: RelativeLayout? = view.findViewById(R.id.ivMediaTileIndicator)
//        var tvSizeText: TextView? = view.findViewById(R.id.tvSizeText)
//        var progressBarForDownload: ProgressBar? = view.findViewById(R.id.progressBarForDownload)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
//            val categoryItem = data[adapterPosition]
//
//            if(listener != null) {
//                if (categoryItem.guid != null) {
//                    listener.leadSelected(categoryItem.guid)
//                } else {
//                    listener.categorySelected(categoryItem.id)
//                }
//            } else {
//                viewListener.onMenuItemChanged(categoryItem)
//            }
        }
    }
}
