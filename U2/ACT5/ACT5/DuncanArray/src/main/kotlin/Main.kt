/**
 *
 * Un programa que crea una array de números hasta que el usuario ponga fin
 * Y le dirá cuantos números de un digito hay, de dos y de tres y cuantos pares.
 * Podra añadir más números o crear una nueva
 *
 * @author Duncan Rua Valiente
 * @version 1.1
 *
 */

import kotlin.math.absoluteValue
fun main(args: Array<String>){
    val saveArray = array()
    do {
        menu()
        val optionFirstMenu = optionMenu()
        if (optionFirstMenu == 1){
            val optionSecondMenu = optionSecondMenu()
            when(optionSecondMenu){
                1-> continueArray(saveArray)
                2-> array()
            }
        }
    }while (optionFirstMenu != 2)
}

/**
 * Crea una array de números que le pide al usuaio
 * @param
 * @return MutableList<Int>, Lo que hace es devolver el array
 */
fun array(): MutableList<Int>{
    var array: MutableList<Int> = mutableListOf()
    val checkString = Regex("[0-9]|fin")
    var number = "null"
    do {
        try {
            println("""|Dime un número""".trimMargin())
            number = readln().lowercase()
            if (number == "fin"){
                checkAllDigits(array)
            }else{
                array.add(number.toInt())
            }
        }catch (e: Exception){
            println("solo puedes poner números enteros positivos o fin")
        }
    }while (number != "fin")
    return array
}
/**
 * Cuenta cuantos números hay de 1 digito, 2 digitos, tres o mas digitos y si hay pares
 * @param array -MutableList<Int>, Le pasa el array anterior
 * @return
 */
fun checkAllDigits(array: MutableList<Int>){
    //comprueba los digitos de los números y si es par
    var countOneDigit = array.count { it in 0..9 }.absoluteValue
    var countDoubleDigit = array.count { it in 10..99 }.absoluteValue
    var countThreeDigit = array.count { it >= 100 }.absoluteValue
    var isEven = array.count { it %2 == 0 }.absoluteValue

    //Devolvemos el resultado
    println("""|De un digito hay: $countOneDigit
               |De dos digitos hay: $countDoubleDigit
               |De tres digitos hay: $countThreeDigit
               |Números pares hay: $isEven 
               |""".trimMargin())
}

/**
 * Saca un menu
 * @param
 * @return
 */
fun menu(){
    println("""|1-Desesas introducir más números
               |2-Acabar programa""".trimMargin())
}
/**
 * Pide la opción por el menu anterior y dependiendo si le dan un 1 o un 2 acaba el programa o continua.
 * @param
 * @return Int -Returnea la opción
 */
fun optionMenu(): Int{
    var option: Int = 0
    do {
        try {
            option = readln().toInt()
        }catch (e: Exception){
            println("Pon un número del 1 al 2")
        }
        when(option){
            1-> secondMenu()
            2-> println("Hasta luego")
        }
    }while (option != 1 && option != 2)
    return option
}

/**
 * Saca un segundo menu
 * @param
 * @return
 */
fun secondMenu(){
    println("""|1-Quiere continuar con los números introducidos anteriores
               |2-Comenzar de nuevo""".trimMargin())
}

/**
 * Pide la opción del segundo menu si pone 1 añadira mas números al array si pone 2 empezara una nueva.
 * @param
 * @return Int -Returnea la opción
 */
fun optionSecondMenu(): Int{
    var option: Int = 0
        try {
            option = readln().toInt()
        }catch (e: Exception){
            println("Solo puedes `poner 1 o 2")
        }
    return option
}

/**
 * Continua con el array que teniamos y le añade más números.
 * saca por pantalla cuantos números tienen 1 digito, 2 digitos, 3 o mas digitos y si es par.
 * @param
 * @return Int -Returnea la opción
 */
fun continueArray(array: MutableList<Int>): MutableList<Int>{
    val checkString = Regex("[0-9]|fin")
    var number = "null"
    do {
        println("""|Dime un número""".trimMargin())
        number = readln().lowercase()
        if (number == "fin"){
            checkAllDigits(array)
        }else{
            array.add(number.toInt())
        }
    }while (number != "fin")
    return array
}