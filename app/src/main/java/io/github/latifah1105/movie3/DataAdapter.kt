package io.github.latifah1105.movie3

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.latifah1105.movie3.model.Result
import kotlinx.android.synthetic.main.item_rv.view.*

class DataAdapter : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private val mData = ArrayList<Result>()

    fun setData(items: ArrayList<Result>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Result)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mData: Result){
            with(itemView){
                txt_title.text = mData.title
                txt_overview.text = mData.overview
                Glide.with(context).load(mData.getPosterUrl()).into(image_view)
                setOnClickListener { onItemClickCallback?.onItemClicked(mData) }
            }
        }
    }

}
