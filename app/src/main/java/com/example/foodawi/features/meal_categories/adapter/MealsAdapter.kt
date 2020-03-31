package com.example.foodawi.features.meal_categories.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.foodawi.R
import com.example.foodawi.common.model.categories.mealsResponse.Meal
import com.example.foodawi.common.model.categories.mealsResponse.MealsResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.meals_items.view.*

class MealsAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Meal>() {

        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean =
            oldItem.idMeal == newItem.idMeal

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean =
            oldItem.idMeal == newItem.idMeal

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MealsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.meals_items,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MealsViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Meal>) {
        differ.submitList(list)
    }

    class MealsViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Meal) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            val picasso = Picasso.get()
            picasso.load(item.strMealThumb).resize(150,150).placeholder(R.drawable.loading_animation).into(itemView.iv_mealImage)
            itemView.tv_meal_name.text = item.strMeal
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Meal)
    }
}

