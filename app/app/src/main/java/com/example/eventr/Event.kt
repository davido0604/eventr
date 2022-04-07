package com.example.eventr

class Events(
    var ms: Int,
    query: String,
    result: List<Event>
)  {
}

class Event(
    var _createdAt: String,
    var id: String,
    var description: String,
    var endDateAndTime: String,
    var hosts: Host,
    var location: Location,


) {

}

class Host(
    email: String?,
    name: String
) {

}

class Location(
    address: String,
    city: List<String>,

) {

}

class City(

) {

}