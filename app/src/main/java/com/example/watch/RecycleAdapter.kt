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
var titleList : ArrayList<Titles> = ArrayList()

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

    fun setTitleListItems(titleListparam: ArrayList<Titles>){
        titleList = titleListparam;
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView!!.findViewById(R.id.item_title)
        private val image: ImageView = itemView!!.findViewById(R.id.item_image)
        private var pos:Int = 0

        init {
            itemView.setOnClickListener {
                //val action = SearchResultFragmentDirections.actionSearchResultFragmentToCardFragment()
                //navController.navigate(action)
            }
        }

        fun bind(position:Int){
            pos = position
            val currTitle = titleList[position]
            title.text = currTitle.title
            Glide.with(context).load(currTitle.imageurl)
                .apply(RequestOptions().centerCrop())
                .into(image)
        }

    }
}