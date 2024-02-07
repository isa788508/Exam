package com.example.projectwork.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.projectwork.core.model.top_headline.BannerResult
import com.example.projectwork.core.model.top_headline.TopHeadline
import com.example.projectwork.databinding.ItemBannerBinding

class BannerAdapter : RecyclerView.Adapter<BannerAdapter.banerFilmViewHolder>() {

    private val data = ArrayList<BannerResult>()

    fun setData(data: List<BannerResult>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }


    inner class banerFilmViewHolder(private val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: BannerResult) {
            binding.bannerReviews.text = data.voteAverage.toString()
            binding.bannerDescription.text = data.title
            binding.bannerPhoto.load("https://image.tmdb.org/t/p/original${data.posterPath}")
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerAdapter.banerFilmViewHolder {
        return banerFilmViewHolder(
            ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: BannerAdapter.banerFilmViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount():Int=data.size

}