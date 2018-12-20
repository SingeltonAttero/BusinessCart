package com.yakov.weber.businesscart.ui.ready.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.entity.BusinessCard
import com.yakov.weber.businesscart.extension.inflate
import kotlinx.android.synthetic.main.include_email.view.*
import kotlinx.android.synthetic.main.include_site.view.*
import kotlinx.android.synthetic.main.include_space.view.*
import kotlinx.android.synthetic.main.include_title.view.*

/**
 * Created on 21.12.18
 * @author YWeber
 * project BusinessCart */

class CardAdapter(
    private val listCard: List<BusinessCard>,
    private val click: (position: Int, card: BusinessCard) -> Unit) : RecyclerView.Adapter<CardAdapter.CardHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = parent.inflate(R.layout.item_recycler_card)
        return CardHolder(view)
    }

    override fun getItemCount(): Int = listCard.size

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(listCard[position])
    }

    inner class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(card: BusinessCard) {
            itemView.setOnClickListener { click(adapterPosition, card) }
            itemView.title_name.text = card.name
            itemView.title_post.text = card.post
            itemView.space_card.text = card.place
            itemView.site_card.text = card.site
            itemView.email_card.text = card.email

        }
    }
}