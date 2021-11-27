package com.sahibinden.hackathon.mock


class Adress {

    fun getAdressList(): List<City> {

        val c1: City = City(
            "Antalya",
            listOf(
                District(
                    "Kepez",
                    listOf(
                        Neighbourhood("Altınova Mh."),
                        Neighbourhood("Atatürk Mh."),
                        Neighbourhood("Erenköy Mh.")
                    )
                ),
                District(
                    "Muratpaşa",
                    listOf(
                        Neighbourhood("Elmalı Mh."),
                        Neighbourhood("Yıldız Mh."),
                        Neighbourhood("Deniz Mh.")
                    )
                ),
                District(
                    "Konyaaltı",
                    listOf(
                        Neighbourhood("Çakırlar Mh."),
                        Neighbourhood("Liman Mh."),
                        Neighbourhood("Pınarbaşı Mh.")
                    )
                )
            )
        )

        val c2: City = City(
            "Eskişehir",
            listOf(
                District(
                    "Tepebaşı",
                    listOf(
                        Neighbourhood("Yenibağlar Mh."),
                        Neighbourhood("Bahçelievler MH."),
                        Neighbourhood("Eskibağlar Mh.")
                    )
                ),
                District(
                    "Odunpazarı",
                    listOf(
                        Neighbourhood("Kalkanlı Mh."),
                        Neighbourhood("Vişnelik Mh."),
                        Neighbourhood("Paşa Mh.")
                    )
                ),
                District(
                    "Seyitgazi",
                    listOf(
                        Neighbourhood("Çürüttüm Mh."),
                        Neighbourhood("Çukurca Mh."),
                        Neighbourhood("Yunus Mh.")
                    )
                )
            )
        )

        return listOf<City>(c1,c2)
    }
}


data class City(
    val cityName: String,
    val districts: List<District>
){
    override fun toString(): String {
        return cityName
    }
}
data class District(
    val districtName: String,
    val neighbourhoods: List<Neighbourhood>
){
    override fun toString(): String {
        return districtName
    }
}
data class Neighbourhood(
    val neighbourhoodName: String
){
    override fun toString(): String {
        return neighbourhoodName
    }
}
