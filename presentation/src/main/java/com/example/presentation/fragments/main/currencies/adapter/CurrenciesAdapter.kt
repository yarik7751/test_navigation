package com.example.presentation.fragments.main.currencies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import com.example.presentation.fragments.main.currencies.model.CurrencyModel
import kotlinx.android.synthetic.main.item_currency.view.*

class CurrenciesAdapter(
    val models: List<CurrencyModel>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TITLE = 1
        const val INFO = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if(models[position].titleType) TITLE else INFO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TITLE -> {
                CurrenciesViewHolder(
                    initViewForHolder(parent, R.layout.item_currency_title)
                )
            }

            INFO -> {
                CurrenciesViewHolder(
                    initViewForHolder(parent, R.layout.item_currency)
                )
            }

            else -> {
                CurrenciesViewHolder(
                    initViewForHolder(parent, R.layout.item_currency)
                )
            }
        }
    }

    private fun initViewForHolder(parent: ViewGroup, @LayoutRes res: Int): View {
        return LayoutInflater.from(parent.context).inflate(res, parent, false)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as CurrenciesViewHolder
        val item = models[position]

        viewHolder.tvTitle.text = item.title
        viewHolder.tvPurchase.text = item.purchase
        viewHolder.tvSale.text = item.sale
    }

    override fun getItemCount(): Int = models.size

    class CurrenciesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.tvCurrencyTitle
        val tvPurchase = itemView.tvCurrencyPurchase
        val tvSale = itemView.tvCurrencySale
    }
}