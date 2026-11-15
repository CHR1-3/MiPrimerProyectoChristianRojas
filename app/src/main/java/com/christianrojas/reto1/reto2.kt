package com.christianrojas.reto2.ui.theme

//1. Completa el código para que imprima: "Mary is 20 years old"
fun ejercicio1() {
    val name = "Mary"
    val age = 20
    println("$name is $age years old")
}

//2. Declara de manera explícita el tipo de cada variable:
fun ejercicio2() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'
}

/*3. Tienes dos listas: una con números rojos y otra con números verdes.
Completa el código para imprimir cuántos números hay en total:*/
fun ejercicio3() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val total = greenNumbers.count() + redNumbers.count()
    println("Total: $total")
}

/*4. Tienes un set de protocolos soportados por tu servidor. Un usuario pregunta por determinado
protocolo y tú debes completar el código para informar si ese protocolo es soportado o no:*/
fun ejercicio4() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")
}

/*5. Crea un mapa mutable que guarde el nombre de tres alumnos y su nota:*/
fun ejercicio5() {
    val notasAlumnos: MutableMap<String, Double> = mutableMapOf(
        "Victor" to 9.9,
        "Luis" to 7.0,
        "Diego" to 4.9
    )
    println(notasAlumnos)
}

//6. Crea un juego donde ganas si al tirar dos dados salen los mismos números.
fun ejercicio6() {
    val firstResult = kotlin.random.Random.nextInt(6)
    val secondResult = kotlin.random.Random.nextInt(6)

    println("Dado 1: $firstResult - Dado 2: $secondResult")
    if (firstResult == secondResult) {
        println("HAS GANADO!!!")
    } else {
        println("QUE PRINGADO")
    }
}

/*7. Usa la expresión when y actualiza el siguiente programa para que imprima las acciones
correspondientes según la letra que ponga:*/
fun ejercicio7() {
    val button = "A"
    println(
        when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        }
    )
}

//Main para comprobar que funciona todo Neus.
fun main() {
    ejercicio1()
    ejercicio2()
    ejercicio3()
    ejercicio4()
    ejercicio5()
    ejercicio6()
    ejercicio7()
}