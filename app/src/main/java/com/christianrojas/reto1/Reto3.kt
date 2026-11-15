package com.christianrojas.reto2.ui.theme

fun main(){
    ejercicio1_3()
    ejercicio2_3()
    ejercicio3_3()
}

/*
1. Crea un programa donde: Pide al usuario una contraseña y comprueba que:
- Tiene al menos ocho caracteres.
- Contiene una mayúscula.
- Contiene una minúscula.
- Contiene un número.
- No contiene espacios.
*/
fun ejercicio1_3() {
    var mayuscula = false
    var minuscula = false
    var numero = false
    var espacios = false

    println("""
        Requisitos de cotraseña
        -Tiene al menos ocho caracteres.
        -Contiene una mayúscula.
        -Contiene una minúscula.
        -Contiene un número.
        -No contiene espacios.
    """)
    println("Introduce una contraseña: ")
    val password = readln()

    for (letra in password) {
        if (letra.isUpperCase()) {
            mayuscula = true
        }
        if (letra.isLowerCase()) {
            minuscula = true
        }
        if (letra.isDigit()) {
            numero = true
        }
        if (letra == ' ') {
            espacios = true
        }
    }

    var errores = ""

    if (password.length < 8) {
        errores += "Faltan caracteres."
    }
    if (!mayuscula) {
        errores += "Falta una letra mayúscula."
    }
    if (!minuscula) {
        errores += "Falta una letra minúscula."
    }
    if (!numero) {
        errores += "Falta un número."
    }
    if (espacios) {
        errores += "No tiene que espacios. "
    }

    if (errores == "") {
        println("GOOD.")
    } else {
        println("No cumple los requisitos: $errores")
    }
}

/*
2. Crea un programa donde: El usuario introduce temperaturas hasta escribir fin.
El programa debe mostrar:
- La temperatura máxima.
- La mínima.
- La media.
- Cuántas temperaturas están por encima de la media.
- La diferencia máxima entre dos temperaturas consecutivas.
- Si la temperatura subió, bajó o se mantuvo entre cada medición.
*/
fun ejercicio2_3() {
    val temperaturas: MutableList<Double> = mutableListOf()
    var entrada = ""

    println("Introduce las temperaturas (escribe 'fin' para terminar):")
    while (entrada != "fin") {
        entrada = readln()
        if (entrada != "fin") {
            val temp = entrada.toDoubleOrNull()
            if (temp != null) {
                temperaturas.add(temp)
            } else {
                println("ERROR 404")
            }
        }
    }

    if (temperaturas.count() == 0) {
        println("Que quieres que calcule si no has puesto nada.")
        return
    }

    var maxima = temperaturas[0]
    var minima = temperaturas[0]
    var suma = 0.0

    //máxima, mínima y suma
    for (t in temperaturas) {
        if (t > maxima) maxima = t
        if (t < minima) minima = t
        suma += t
    }

    val media = suma / temperaturas.count()

    //Encima de la media
    var encimaMedia = 0
    for (t in temperaturas) {
        if (t > media) {
            encimaMedia++
        }
    }

    //variaciones
    var variacion = 0.0
    println("\nEvolución entre mediciones:")
    for (i in 1 until temperaturas.count()) {
        val anterior = temperaturas[i - 1]
        val actual = temperaturas[i]
        var diferencia = actual - anterior
        if (diferencia < 0) {
            diferencia = -diferencia
        }

        if (diferencia > variacion) {
            variacion = diferencia
        }

        if (actual > anterior) {
            println("De $anterior a $actual -> Subió")
        } else if (actual < anterior) {
            println("De $anterior a $actual -> Bajó")
        } else {
            println("De $anterior a $actual -> Se mantuvo")
        }
    }

    println("\nResultados:")
    println("Máxima: $maxima")
    println("Mínima: $minima")
    println("Media: $media")
    println("Por encima de la media: $encimaMedia")
    println("Mayor variación consecutiva: $variacion")
}

/*
3. Crea una variable llamada correo que pueda contener un String o null.
Usa ?.let para mostrar el siguiente mensaje únicamente cuando el correo no sea null:
"Enviando mensaje a alumno@correo.com". Si el correo es nulo imprime: "No se ha indicado ningún correo"
*/
fun ejercicio3_3() {
    val correo: String? = "alumno@correo.com"

    correo?.let {
        println("Enviando a $it")
    } ?: println("Soy adivino? Introduce un Correo valido.")
}