package com.example.lab3and

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3and.databinding.FlowerItemBinding

class FlowerAdapter(
    private val flowerDataSet: List<Flower>
) : RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {

    class ViewHolder(private val bnd: FlowerItemBinding) : RecyclerView.ViewHolder(bnd.root) {
        val tvFlowerName = bnd.tvFlowerName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bnd = FlowerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bnd)
    }

    override fun getItemCount() = flowerDataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentFlower = flowerDataSet[position]
        holder.tvFlowerName.text = "${currentFlower.polishName} ${currentFlower.englishName}"
    }
}