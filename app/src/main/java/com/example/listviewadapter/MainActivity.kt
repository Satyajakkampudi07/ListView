package com.example.listviewadapter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView : ListView = findViewById(R.id.list_view)
        val edt: EditText= findViewById(R.id.edt)
        val btn:Button = findViewById(R.id.btn)

        val listOfitems = mutableListOf<String>()
        val namesAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listOfitems)
        listView.adapter = namesAdapter

        btn.setOnClickListener {
            val text = edt.text.toString()
            listOfitems.add(text)
            namesAdapter.notifyDataSetChanged()
        }

        listView.setOnItemClickListener(object : OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                val clicked = listOfitems[position]
//                Toast.makeText(this@MainActivity,clicked,Toast.LENGTH_SHORT).show()
                val deleted = listOfitems.removeAt(position)
                Toast.makeText(this@MainActivity,"deleted successfully $deleted",Toast.LENGTH_SHORT).show()
                namesAdapter.notifyDataSetChanged()


            }
        })

        }
}
