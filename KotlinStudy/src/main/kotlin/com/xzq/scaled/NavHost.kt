package com.xzq.scaled

sealed class TravelAdvisoriesDestination(val route: String) {

    class AboutDestination

    class CountryListDestination : TravelAdvisoriesDestination("AAAAAA")

    object CountryDetailsDestination

    object TravelAdvisoriesNavHost : TravelAdvisoriesDestination("BBBBBB")

}

fun main() {
    println("==  ${TravelAdvisoriesDestination.TravelAdvisoriesNavHost.route}")
}