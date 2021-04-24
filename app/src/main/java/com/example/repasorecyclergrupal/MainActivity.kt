package com.example.repasorecyclergrupal

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.io.*
import java.lang.reflect.Type
import java.nio.charset.Charset


class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    lateinit var lista: List<Producto>
    lateinit var adapter: RecyclerAdapter
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler_copetes)
        initCharacter()
    }

    private fun initCharacter() {
        /*if (licores.status == "success") {
            lista = licores.data
        }*/
        info()
        adapter = RecyclerAdapter(lista,this.applicationContext)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

    }

    fun info() {                                                //metodo para acceder al archivo del JSON y transformarlo a String
        var json: String? = ""                                  //Class inputStream trabajar con bytes
        try {
            val inputStream: InputStream = assets.open("jsonfile")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            json = String(buffer)                       //el buffer de tipo bytearray se transforma a String que se almacena en var json
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val gson = Gson()   //constructor Gson
        val jobj: JsonObject = Gson().fromJson(json, JsonObject::class.java)

        val listproductosType = object : TypeToken<List<Producto>>() {}.type
        lista = gson.fromJson(jobj["data"], listproductosType)
        System.out.println(lista)
        //val p: Producto = gson.fromJson(jobj["data"], Producto::class.java)
        //System.out.println(json)
    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this.applicationContext, "asdasd", Toast.LENGTH_SHORT).show()
    }
}