package com.example.sem5_s1_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var contacts = ArrayList<Contact>()
    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()

        initView()
    }

    private fun initView() {
        val rvAgenda = findViewById<RecyclerView>(R.id.rvAgenda)
        rvAgenda.adapter = contactAdapter
        rvAgenda.layoutManager = LinearLayoutManager(this)
    }

    private fun loadContacts() {
        contacts.add(Contact("Samir", "123456789"))
        contacts.add(Contact("Carlos", "123000789"))
        contacts.add(Contact("Sandra", "123456000"))
        contacts.add(Contact("Sara", "100456000"))
        contacts.add(Contact("Samir", "123456789"))
        contacts.add(Contact("Carlos", "123000789"))
        contacts.add(Contact("Sandra", "123456000"))
        contacts.add(Contact("Sara", "100456000"))
        contacts.add(Contact("Samir", "123456789"))
        contacts.add(Contact("Carlos", "123000789"))
        contacts.add(Contact("Sandra", "123456000"))
        contacts.add(Contact("Sara", "100456000"))
        contacts.add(Contact("Samir", "123456789"))
        contacts.add(Contact("Carlos", "123000789"))
        contacts.add(Contact("Sandra", "123456000"))
        contacts.add(Contact("Sara", "100456000"))
    }
}