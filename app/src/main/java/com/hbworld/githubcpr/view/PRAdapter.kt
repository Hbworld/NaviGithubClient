package com.hbworld.githubcpr.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hbworld.githubcpr.R
import com.hbworld.githubcpr.data.model.FetchCPRResponse

class PRAdapter(private var prList: List<FetchCPRResponse>) :
    RecyclerView.Adapter<PRAdapter.PRViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PRViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pr_card, parent, false)
        return PRViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PRViewHolder, position: Int) {
        val pr = prList[position]
        holder.tvPRId.text = pr.number
        holder.tvPRTitle.text = pr.title
        holder.tvAuthorName.text = pr.user.login
        holder.tvPRCreated.text = pr.createdAt
        holder.tvPRClosedAt.text = pr.closedAt
        holder.ivAuthorImage.load(pr.user.avatarUrl)
    }

    override fun getItemCount(): Int {
        return prList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    public fun updateList(prList: List<FetchCPRResponse>){
        this.prList = prList
        notifyDataSetChanged()
    }


    class PRViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       val tvPRId = view.findViewById(R.id.tv_pr_id) as TextView
       val tvPRTitle = view.findViewById(R.id.tv_pr_title) as TextView
       val tvAuthorName = view.findViewById(R.id.tv_author_name) as TextView
       val tvPRCreated = view.findViewById(R.id.tv_pr_created) as TextView
       val tvPRClosedAt = view.findViewById(R.id.tv_pr_closed) as TextView
       val ivAuthorImage = view.findViewById(R.id.iv_author_image) as ImageView


    }
}