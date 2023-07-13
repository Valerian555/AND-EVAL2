package com.technipixl.and_eval2_exo2

class Items(var name: String, var quantity: String, var type:Types) {
}

enum class Types() {
    Nourriture,
    Boisson,
    Hygiène,
    Maison
}

val itemList = mutableListOf<Items>()