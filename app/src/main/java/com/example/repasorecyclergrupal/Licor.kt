package com.example.repasorecyclergrupal

import com.google.gson.annotations.SerializedName


data class Licor(@SerializedName("status") var status:String,
                 @SerializedName("data") var data:List<Producto>,
                 @SerializedName("message") var message:String)


