package com.example.infraveotest.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infraveotest.Model.InfraveoItem
import com.example.infraveotest.R
import com.squareup.picasso.Picasso

class InfraveoAdapter(val userList : ArrayList<InfraveoItem>) : RecyclerView.Adapter<InfraveoAdapter.Holder>() {
     class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val userName : TextView = itemView.findViewById(R.id.userNameTextView)
         val userEmail : TextView = itemView.findViewById(R.id.emailTextView)
         val profile : ImageView = itemView.findViewById(R.id.userProfileImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ui_cardview,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        //two data have wrong url of image so they wont be displayed :)

        holder.userName.text = userList[position].username
        holder.userEmail.text = userList[position].email
        Picasso.get().load(userList[position].profile).into(holder.profile)
    }
}