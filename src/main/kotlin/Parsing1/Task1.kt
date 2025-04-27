package org.example.Parsing1

import org.jsoup.Jsoup

fun main() {
    val url = "https://mybook.ru/author/duglas-adams/avtostopom-po-galaktike-restoran-u-konca-vselennoj/citations/"

    try {
        val document = Jsoup.connect(url).get()
        val quotes = document.select("div.sc-2aegk7-2.bzpNIu")

        if (quotes.isEmpty()) {
            println("No quotes found on the page.")
        } else {
            println("Quotes  from 'The Hitchhiker's Guide to the Galaxy':\n")
            quotes.forEachIndexed { index, element ->
                println("${index + 1}. ${element.text()}")
                println()
            }
        }
    } catch (e: Exception) {
        println("Failed to connect or parse the page: ${e.message}")
    }
}