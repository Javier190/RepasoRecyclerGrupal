package com.example.repasorecyclergrupal

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(lista: List<Producto>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var licores: MutableList<Producto>  = ArrayList()
    lateinit var context: Context

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = licores.get(position)
        holder.bind(item, context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.lista_licores, parent, false))
    }

    override fun getItemCount(): Int {
        return licores.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_nombre = view.findViewById(R.id.tv_nombre) as TextView
        val tv_tipo = view.findViewById(R.id.tv_tipo) as TextView
        val tv_pais = view.findViewById(R.id.tv_pais) as TextView
        val tv_formato = view.findViewById(R.id.tv_formato) as TextView
        val tv_precio = view.findViewById(R.id.tv_precio) as TextView
        @SuppressLint("ResourceType")
        val image_licor = view.findViewById(R.id.image_licor) as ImageView


        fun bind(producto:Producto, context: Context){
            tv_nombre.text = producto.nombre_licor
            tv_tipo.text = producto.tipo_licor
            tv_pais.text = producto.pais_origen
            tv_formato.text = producto.formato
            tv_precio.text = producto.precio
            image_licor.setImageResource(R.drawable.ron)

            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, producto.nombre_licor, Toast.LENGTH_SHORT).show()
            })
        }

    }
}

