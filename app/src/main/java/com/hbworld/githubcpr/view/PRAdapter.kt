package com.hbworld.githubcpr.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.hbworld.githubcpr.data.model.FetchCPRResponse
import com.hbworld.githubcpr.databinding.ItemPrCardBinding
import com.hbworld.githubcpr.BR

class PRAdapter(private var prList: List<FetchCPRResponse>) :
    RecyclerView.Adapter<PRAdapter.PRViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PRViewHolder {
        val dataBinding =
            ItemPrCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PRViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: PRViewHolder, position: Int) {
        val pr = prList[position]
        holder.bind(pr)
    }

    override fun getItemCount(): Int {
        return prList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    public fun updateList(prList: List<FetchCPRResponse>) {
        this.prList = prList
        notifyDataSetChanged()
    }


    class PRViewHolder(private val dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(pr: FetchCPRResponse) {
            dataBinding.setVariable(BR.pr, pr)
        }


    }
}