package com.dicoding.klubbolaindonesialiga1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.dicoding.klubbolaindonesialiga1.databinding.ItemRowClubBinding
@GlideModule
class ListClubAdapter(private val listClub: ArrayList<Club>): RecyclerView.Adapter<ListClubAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowClubBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listClub.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nameClub, fullNameClub, photoClub, descClub) = listClub[position]
        holder.binding.tvItemName.text = nameClub
        holder.binding.tvItemFullName.text = fullNameClub
        Glide.with(holder.itemView.context)
            .load(photoClub)
            .into(holder.imgPhoto)
        holder.itemView.setOnClickListener {
            val model = listClub[position]
            val name: String = model.nameClub
            val photo: String = model.photoClub
            val desc: String = model.descClub

            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("nama", name)
            intentDetail.putExtra("foto", photo)
            intentDetail.putExtra("deskripsi", desc)
            holder.itemView.context.startActivities(arrayOf(intentDetail))
        }
    }

    class ListViewHolder(var binding: ItemRowClubBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}