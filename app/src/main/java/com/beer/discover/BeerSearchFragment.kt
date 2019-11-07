package com.beer.discover

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment

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
//        if (resources.getBoolean(R.bool.hotdogStyleMixMediaScreen) || resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            mainSplitView.orientation = LinearLayout.HORIZONTAL
//        } else {
//            mainSplitView.orientation = LinearLayout.VERTICAL
//        }
//        try {
//            if (placeholderView == null) {
//                placeholderView = view.findViewById(R.id.placeholderWebView) as WebView
//                placeholderView!!.settings.domStorageEnabled = true
//                placeholderView!!.settings.javaScriptEnabled = true
//            }
//            if (::model.isInitialized) {
//                bind()
//                model.addListener(BaseModel.ChangeEvent.EDIT_MODE_CHANGED, updateEditMode)
//                model.addListener(SplitPanelModel.ChangeEvent.MEDIA_LIST_UPDATED, updateMediaList)
//                model.addListener(SplitPanelModel.ChangeEvent.CATEGORY_LIST_UPDATED, updateCategoryList)
//                model.addListener(SplitPanelModel.ChangeEvent.HEADER_UPDATE, updateHeader)
//                model.addListener(SplitPanelModel.ChangeEvent.PLACE_HOLDER, placeholderUpdate)
//            }
//        } catch (e: NoSuchFieldError) {
//            e.printStackTrace()
//            Toast.makeText(context, "Missing Necessary View in Heirarchy", Toast.LENGTH_LONG).show()
//        }
    }

}