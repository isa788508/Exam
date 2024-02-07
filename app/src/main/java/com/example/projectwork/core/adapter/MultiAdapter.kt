package com.example.projectwork.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectwork.core.model.BaseModel
import com.example.projectwork.core.model.popular.OtherResult
import com.example.projectwork.core.model.popular.Popular
import com.example.projectwork.core.model.top_headline.BannerResult
import com.example.projectwork.core.model.top_headline.TopHeadline
import com.example.projectwork.databinding.ItemBannerParrentBinding
import com.example.projectwork.databinding.ItemFilmParentBinding

class MultiAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<BaseModel>()

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }

    inner class BannerParentViewHolder(private val binding: ItemBannerParrentBinding) :
        RecyclerView.ViewHolder(binding.root) {

       private val adapter=BannerAdapter()

        fun bindDataToBannerParent(data:TopHeadline) {

            binding.recyclerView.adapter=adapter
            adapter.setData(data=data.results)


        }
    }

    inner class FilmsParentViewHolder(private val binding: ItemFilmParentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val adapter=FilmsAdapter()

        fun bindDataToFilmsParent(data:Popular) {

            binding.newsRecyclerView.adapter=adapter
            adapter.setData(data=data.results)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            0 -> {
                BannerParentViewHolder(
                    ItemBannerParrentBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }

            else -> {
                FilmsParentViewHolder(
                    ItemFilmParentBinding.inflate(
                        LayoutInflater.from(parent.context),parent,false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type=getItemViewType(position)

        when(type){
            0->{
                (holder as BannerParentViewHolder).bindDataToBannerParent(data[position] as TopHeadline)
            }
            1->{
                (holder as FilmsParentViewHolder).bindDataToFilmsParent(data[position] as Popular)
            }
        }
    }
}