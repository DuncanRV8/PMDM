/**
 *
 * Creamos una matriz bidimensional en la cual le mostramos al usuario un menu y puede editar la matriz
 *
 * @author Duncan Rua Valiente
 * @version 1.1
 *
 */
import kotlin.random.Random
fun main(args: Array<String>) {
    var resultOption = 0
    val size = getSize()
    println("Se ha creado una matriz por defecto")
    var matrix = createMatrix(size)
    do {
        resultOption = menu()
        when(resultOption){
            1-> fillMatrix(matrix)
            2-> printMatrix(matrix)
            3-> searchNumber(matrix)
            4-> sumOneAllNumbers(matrix)
            5-> transposedMatrix(matrix)
        }
    }while (resultOption != 0)
}

/**
 * comprobación que el número sea del 3 al 6
 * @param
 * @return Int - Que será cuanto va a medir la matriz
 */
fun getSize(): Int {
    var number = 0
    do {
        println("Dime un número entre 3 y 6")
        try {
            number = readln().toInt()
        }catch (e: Exception){
            println("No esta en el rango indicado")
        }
    }while (number !in(3..6))
    return number
}

/**
 * menu con opciones
 * @param
 * @return Int - Que será para elegir la opción
 */
fun menu(): Int{
    var number = 0
    do {
        println("""|
               |1-Rellenar matriz de números aleatorios entre 0 y 9
               |2-Mostrar matriz
               |3-Buscar número: entre 0 y 9
               |4-Sumar uno a cada elemento de la matriz
               |5-Traspuesta
               |0-Salir
               |
               |Dime que opción quieres hacer""".trimMargin())
        try {
            number = readln().toInt()
        }catch (e: Exception){
            println("Tiene que ser una de esas opciones.")
        }
    }while (number !in 0..5)
    return number
}
/**
 * creamos la matriz
 * @param  size -Int, Nos dice la largaría de nuestro array
 * @return Array<Array>Int>>, Que es nuestra matriz
 */
fun createMatrix(size: Int): Array<Array<Int>>{
    val matrix = Array(size){Array(size){-1} }
    return matrix
}

/**
 * Rellenar matriz (números aleatorios entre 0 y 9)
 * @param matrix -Array<Array>Int>>, Le pasamos la matriz creada
 * @return
 */
fun fillMatrix(matrix: Array<Array<Int>>){
    for (row in matrix.indices) {
        for (col in matrix[row].indices) {
            matrix[row][col] = Random.nextInt(10)
        }
    }
}
/**
 * Muestra la matriz por pantalla
 * @param matrix -Array<Array>Int>>, Le pasamos la matriz creada
 * @return
 */
fun printMatrix(matrix: Array<Array<Int>>){
    var haveMinusOne: Boolean = false
    for (row in matrix){
        for (number in row){
            if (number == -1){
                haveMinusOne = true
            }
        }
    }
    if (haveMinusOne == true){
        println("No puedes usar esta opción hasta que rellenes el array")
    }else{
        for (row in matrix){
            for (col in row ){
                print("$col")
            }
            println()
        }
    }
}

/**
 * Buscar un número del 0 al 9 en la matriz y decir en que fila esta
 * @param matrix -Array<Array>Int>>, Le pasamos la matriz creada
 * @return
 */
fun searchNumber(matrix: Array<Array<Int>>){
    var haveMinusOne: Boolean = false
    for (row in matrix){
        for (number in row){
            if (number == -1){
                haveMinusOne = true
            }
        }
    }
    if (haveMinusOne == true){
        println("No puedes usar esta opción hasta que rellenes el array")
    }else {
        println("Que número quieres buscar?")
        val number = readln().toInt()
        for ((index, row) in matrix.withIndex()) {
            if (number in row) {
                println("El número $number se encunetra en la fila ${index + 1}")
            } else {
                println("El número no esta en la fila ${index + 1}")
            }
        }
    }
}

/**
 * Suma 1 a todos los número de la matriz y si es 10 lo pasa a 0
 * @param matrix -Array<Array>Int>>, Le pasamos la matriz creada
 * @return
 */
fun sumOneAllNumbers(matrix: Array<Array<Int>>){
    var haveMinusOne: Boolean = false
    for (row in matrix){
        for (number in row){
            if (number == -1){
                haveMinusOne = true
            }
        }
    }
    if (haveMinusOne == true){
        println("No puedes usar esta opción hasta que rellenes el array")
    }else {
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                matrix[row][col] = (matrix[row][col] + 1) % 10
            }
        }
    }
}

/**
 * Hace la trasuesta de la matriz y luego la muestra
 * @param matrix -Array<Array>Int>>, Le pasamos la matriz creada
 * @return
 */
fun transposedMatrix(matrix: Array<Array<Int>>){
    var haveMinusOne: Boolean = false
    for (row in matrix){
        for (number in row){
            if (number == -1){
                haveMinusOne = true
            }
        }
    }
    if (haveMinusOne == true){
        println("No puedes usar esta opción hasta que rellenes el array")
    }else {
        val transposed = Array(matrix.size) { Array(matrix.size) { 0 } }
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                transposed[col][row] = matrix[row][col]
            }
        }
        printMatrix(transposed)
    }
}