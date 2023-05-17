package com.example.audia_project

class mechanic {


    var location:String = ""
    var service:String = ""
    var price:String = ""
    var mechanic_id:String = ""

    constructor( location: String, service: String, price: String, mechanic_id: String) {
        this.location =location
        this.service = service
        this.price = price
        this.mechanic_id = mechanic_id
    }

    constructor()
}