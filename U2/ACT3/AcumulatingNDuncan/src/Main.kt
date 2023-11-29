/**
 * Vamos a pedir un numero al usuario y insertaremos tantos numeros como nos ha dicho
 * y luego los sumaremos si son positivos
 * @author: Duncan Rua Valiente
 * @version: 1.0
 */

fun main(args: Array<String>) {
    //Variables
    var sum = 0.0

    //Pediremos cuantos numeros quiere añadir
    println("Dime cuantos numeros vas a querer poner")
    val n = readln().toInt()
    //Hacer un bucle del 1 hasta el numero que nos ha pedido el usuario.
    for (i in 1 .. n){
        println("Dime un numero")
        val num = readln().toDouble()

        //Guardar el numero si es positivo en la variable sum

        if (num > 0 ){
           sum += num
        }
    }
    println("""|La suma de los números es: 
               |$sum""".trimMargin())
}