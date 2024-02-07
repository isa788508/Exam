package com.example.projectwork.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.projectwork.core.model.popular.OtherResult
import com.example.projectwork.core.model.top_headline.BannerResult
import com.example.projectwork.databinding.ItemBannerBinding
import com.example.projectwork.databinding.ItemFilmsBinding

class FilmsAdapter:RecyclerView.Adapter<FilmsAdapter.filmViewHolder>() {

    private val data = ArrayList<OtherResult>()

    fun setData(data: List<OtherResult>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }


    inner class filmViewHolder(private val binding: ItemFilmsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: OtherResult) {
            binding.filmDescription.text=data.title
            binding.hours.text=data.releaseDate
            binding.filmImage.load("https://image.tmdb.org/t/p/original${data.posterPath}")
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmsAdapter.filmViewHolder {
        return filmViewHolder(
            ItemFilmsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: filmViewHolder, position: Int) {
        holder.bindData(data[position])
    }


    override fun getItemCount():Int=data.size

}
}