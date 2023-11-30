package com.example.bmicalculator.bmihistoryview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bmicalculator.databinding.BmiHistoryItemBinding

class BmiHistoryAdapter(private val bmiHistoryData: List<BmiHistory>) :
    RecyclerView.Adapter<BmiHistoryAdapter.ViewHolder>() {
    class ViewHolder(private val bnd: BmiHistoryItemBinding) : RecyclerView.ViewHolder(bnd.root) {
        val tvBmiHistory = bnd.tvBmiHistory
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bnd = BmiHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bnd)
    }

    override fun getItemCount() =
        bmiHistoryData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentBmiHistory = bmiHistoryData[position]
        holder.tvBmiHistory.text = "${currentBmiHistory.bmi} ${currentBmiHistory.date}"
    }

}