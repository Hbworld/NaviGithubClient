package com.hbworld.githubcpr.view.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hbworld.githubcpr.data.model.FetchCPRResponse
import com.hbworld.githubcpr.view.PRAdapter

object BindingAdapterUtil {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun bindSrc(imageView: ImageView, imageUrl : String) {
        imageView.load(imageUrl)
    }

    @JvmStatic
    @BindingAdapter("prList")
    fun bindPRRecyclerView(recyclerView: RecyclerView, prList : List<FetchCPRResponse>?) {
        if(prList!=null){
            var adapter = recyclerView.adapter
            if (adapter == null && adapter !is PRAdapter) {
                adapter = PRAdapter(prList)
                recyclerView.adapter = adapter
            } else if (adapter is PRAdapter) {
                adapter.updateList(prList)
            }
        }
    }


}