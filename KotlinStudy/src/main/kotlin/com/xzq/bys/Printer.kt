package com.xzq.bys


interface Printer {
    fun print(message: String)
}

class DefaultPrinter : Printer {
    override fun print(message: String) {
        println("Default: $message")
    }
}


class CustomPrinter(delegate: Printer) : Printer by delegate

class CustomPrinter1(private val delegate: Printer) : Printer by delegate



fun main() {
    val printer = DefaultPrinter()
    printer.print("Hello World!")
}