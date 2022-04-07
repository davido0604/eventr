package com.example.eventr

class Events(
    var result: List<Event>,
    var ms: Int,
    var query: String
)  {
}

data class Event(
    var _createdAt: String,
    var _id: String,
    var description: String,
    var endDateAndTime: String,
    var hosts: ArrayList<Host>,
    var location: ArrayList<Location>,
    var picture: Asset,
    var price: Int?,
    //var speakers: ArrayList<Speakers>,
    var startDateAndTime: String,
    var title: String
)


class Host(
    var email: String?,
    var name: String
) {

}

class Location(
    var address: String,
    var city: List<String>,
    var venue : String
) {

}

class Asset(
    var asset: Url
) {

}

class Url(
    var url: String
) {

}

class Speakers(
    //var name: String?,
    //var organization: String?
)
