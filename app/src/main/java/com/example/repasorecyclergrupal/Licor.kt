package com.example.repasorecyclergrupal

import com.google.gson.annotations.SerializedName

//no requerida para el programa porque es para recibir info por internet

data class Licor(@SerializedName("status") var status:String,
                 @SerializedName("data") var data:List<Producto>,
                 @SerializedName("message") var message:String)


