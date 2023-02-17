package com.geektech.rickandmortyapp.api.model

data class Character(
    var id: Int,
    var name:String,
    var status:String,
    var spacies:String,
    var gender:String,
    var origin: LocationData,
    var location: LocationData,
    var image:String,
    var episode:List<String>
)
