package com.example.brikotlin.domain.model.paging

data class PassengerResponse(
    val `data`: List<Passenger>,
    val totalPages: Int,
    val totalPassengers: Int
)
