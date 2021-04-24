package com.example.repasorecyclergrupal

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.io.*
import java.nio.charset.Charset


class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    lateinit var lista:List<Producto>
    lateinit var adapter:RecyclerAdapter
    lateinit var recycler:RecyclerView
    lateinit var licores: Licor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler_copetes)
        initCharacter(licores)
    }

    private fun initCharacter(licores: Licor) {
        if(licores.status == "success"){
            lista = licores.data
        }
        info()
        adapter = RecyclerAdapter(lista)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

        val fileName = "file:///android_asset/jsonfile"
        val myFile = File(fileName)
        var ins: InputStream = myFile.inputStream()
        var content = ins.readBytes().toString(Charset.defaultCharset())

    fun info (){

        var json: String? = ""
        try {
            val inputStream: InputStream = assets.open("jsonfile")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            json = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val gson = Gson()
        val jobj: JsonObject = Gson().fromJson(json, JsonObject::class.java)
        val p: Producto = gson.fromJson(jobj["data"], Producto::class.java)
        System.out.println(json)
    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long){

    }
}