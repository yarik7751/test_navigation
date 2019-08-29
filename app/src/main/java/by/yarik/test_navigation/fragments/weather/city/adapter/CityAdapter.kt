package by.yarik.test_navigation.fragments.weather.city.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.yarik.test_navigation.R
import by.yarik.test_navigation.fragments.weather.city.model.CityModel
import kotlinx.android.synthetic.main.item_city.view.*

class CityAdapter(
    val cityItems: List<CityModel>,
    val onCityClick: (cityModel: CityModel) -> Unit = {cityModel -> }
): RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val item = cityItems[position]
        holder.tvCity.text = item.title
        holder.tvCity.setOnClickListener {
            onCityClick(item)
        }
    }

    override fun getItemCount(): Int = cityItems.size

    class CityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvCity: TextView = itemView.tvCity
    }
}