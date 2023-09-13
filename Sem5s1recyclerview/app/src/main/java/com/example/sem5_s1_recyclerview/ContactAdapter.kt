package com.example.sem5_s1_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ContactAdapter(var contacts: ArrayList<Contact>): Adapter<ContactPrototype>() {
    //Crea el prototypo para c/registro
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater.from(
            parent.context).inflate(R.layout.prototype_agenda, parent, false)

        return ContactPrototype(view)
    }

    //Vincula la informacion para c/registro
    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        holder.bind(contacts.get(position))
    }

    //controla el tamaño
    override fun getItemCount(): Int {
        return contacts.size
    }

}

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvTelephone = itemView.findViewById<TextView>(R.id.tvTelephone)

    fun bind(contact: Contact){
        tvName.text = contact.name
        tvTelephone.text = contact.telephone
    }

}
