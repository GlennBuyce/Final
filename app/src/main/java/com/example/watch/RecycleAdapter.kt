/*
Glenn Buyce
May 2023
SER210 Final Project
Watch
 */
package com.example.watch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

var titleList : ArrayList<Result> = ArrayList()

class RecycleAdapter(val context: Context,  var navController: NavController) : RecyclerView.Adapter<RecycleAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.bind(position)
    }

    fun setTitleListItems(titleListparam: Data){
        titleList.addAll(titleListparam.results)
        notifyDataSetChanged()
    }

    fun setRecommendationListItems(titleListparam: Data){
        titleList.addAll(titleListparam.results);
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView!!.findViewById(R.id.item_title)
        private val image: ImageView = itemView!!.findViewById(R.id.item_image)
        private var pos:Int = 0

        init {
            itemView.setOnClickListener {
                val action = SearchResultFragmentDirections.actionSearchResultFragmentToCardFragment(pos)
                navController.navigate(action)
            }
        }
        fun bind(position:Int){
            pos = position
            val currTitle = titleList.get(pos)
            if(currTitle.titleText != null){
                title.text = currTitle.titleText.text
            }
            if(currTitle.primaryImage != null){
                Glide.with(context).load(currTitle.primaryImage.url)
                    .apply(RequestOptions().centerCrop())
                    .into(image)
            }
        }
    }
}