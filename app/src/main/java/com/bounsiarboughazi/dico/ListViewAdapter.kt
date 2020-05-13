package com.bounsiarboughazi.dico

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ListViewAdapter(var context : Context?, var mots: ArrayList<Mot>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val rowView = layoutInflater.inflate(R.layout.mot_listitem, parent, false)
        val motTV = rowView.findViewById<TextView>(R.id.mot_tv)

        val current = mots[position]
        motTV.text = current.nom

        return rowView
    }

    override fun getItem(position: Int): Any {
        return mots[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getCount(): Int {
        return  mots.count()
    }

}