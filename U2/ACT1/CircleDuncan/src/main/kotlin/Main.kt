/**
 * Programa que calcula el perimetro, area y volumen.
 * @author: Duncan Rua Valiente
 * @version: 1.0
 */

fun main(args: Array<String>) {
    println("Dime el radio de la circunferencia")

    val pi = 3.1416
    val radio: Double = readln().toDouble()
    val area: Double = pi * (radio * radio)
    val perimeter: Double = (2 * pi) * radio
    val volume: Double = (4/3 * pi) * ( radio * radio * radio)

    println("""|El area del circulo es: $area
               |El perimetro del circulo es: $perimeter
               |El volumen del circulo es: $volume""".trimMargin())
}