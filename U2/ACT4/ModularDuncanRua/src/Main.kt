/**
 *
 * Este programa lo que hace es calcular dos números, el usuario elige la operación.
 *
 * @author Duncan Rua Valiente
 * @verion 1.1
 *
 */

//pedir al usuario el nombre y saludarlo
fun greetUser(){
    //Que la primera sea en mayusculas y que no pueda tener números
    val checkName = Regex("^[A-Z][a-z]+$")
    //comprobar que el nombre esta bien
    do {
        print("Dime tu nombre: ")
        val name = readln()
        if (checkName.matches(name)){
            println("""|Hola $name""".trimMargin())
            menu()
        }
    }while (checkName.matches(name) != true)
}

//metodo para el menú
fun menu(){
    var option: Int
    do {
        //le enseñamos el menu de lo que puede hacer y le pedimos que elija una opcion.
        println("""|
                  |1-suma
                  |2-resta
                  |3-multiplicar
                  |4-dividir
                  |5-potencia
                  |0-salir
                  |
                  |Elige una opcion""".trimMargin())
        option = readln().toInt()

        //pedimos dos números para hacer la operación
        if (option != 0){
            println("""| 
                      |Dime dos números:""".trimMargin())
            val num1 = getDouble()
            val num2 = readln().toDouble()

            selectMenu(option,num1, num2)
            //depende de la opción del usuario hará una operación.

        }else println("Hasta la próxima!")
    }while(option != 0)
}

//comprobar los numeros
fun getDouble(num: Double){
    println("Dime un número: ")
    val num1 = readln().toDouble()
    if (num1 != Double)
}

//metodo para el Menu
fun selectMenu(option: Int, num1: Double, num2: Double){
    when(option){
        1-> sumNumbers(num1,num2)
        2-> substractNumbers(num1,num2)
        3-> multiplyNumbers(num1,num2)
        4-> divideNumbers(num1,num2)
        5-> potencyNumbers(num1,num2)
    }
}
//metodo para las suma
fun sumNumbers(num1: Double, num2: Double){
    val resultNum = num1 + num2
    println("El resultado de $num1 + $num2 = $resultNum")
}
//metodo para la resta
fun substractNumbers(num1: Double, num2: Double){
    val resultNum = num1 - num2
    println("El resultado de $num1 - $num2 = $resultNum")
}
//metodo para la multiplicación
fun multiplyNumbers(num1: Double, num2: Double){
    val resultNum = num1 * num2
    println("El resultado de $num1 x $num2 = $resultNum")
}

//metodo para la división
fun divideNumbers(num1: Double, num2: Double){
    var resultNum: Double = 0.0
    if (num1 != 0.0) resultNum = num1 / num2 else println("El primer número no puede ser un 0")
    println("El resultado de $num1 / $num2 = $resultNum")
}

//metodo para la potencia
fun potencyNumbers(num1: Double, num2: Double){
    val convertToInt = num2.toInt()
    var resultNum = 1.0
    for (i in 1..convertToInt){
        resultNum *= num1
    }
    println("El resultado de $num1 elevado a $num2 = $resultNum")
}

fun main(args: Array<String>) {
    greetUser()
}