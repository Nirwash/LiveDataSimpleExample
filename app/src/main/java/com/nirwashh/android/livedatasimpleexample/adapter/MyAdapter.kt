package com.nirwashh.android.livedatasimpleexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nirwashh.android.livedatasimpleexample.databinding.ItemBinding
import com.nirwashh.android.livedatasimpleexample.model.User

class MyAdapter() : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var users: List<User> = ArrayList()

    inner class MyViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding) {
                tvName.text = user.name
                tvAge.text = user.age.toString()
            }
        }

    }

    fun refreshUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(users[position])


    override fun getItemCount() = users.size

}