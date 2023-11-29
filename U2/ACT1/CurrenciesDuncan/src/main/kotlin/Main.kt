//@Duncan
//version 1.0
fun main(args: Array<String>) {
    println("Dime la cantidad de euros que quieres convertir")

    //Guardar los calculos de las conversiones
    val euros = readln().toDouble()
    val dollars: Double = euros * 1.07
    val pounds: Double = euros * 0.86
    val yenes: Double = euros * 157.49

    println("""|La conversión de euros a dolares es: $dollars 
               |La conversión de euros a libras es: $pounds
               |La conversión de euros a yenes es: $yenes""".trimMargin())

}