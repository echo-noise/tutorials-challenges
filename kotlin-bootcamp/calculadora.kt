fun somar(a:Float, b:Float):Float = a + b
fun subtrair(a:Float, b:Float):Float = a - b
fun multiplicar(a:Float, b:Float):Float = a * b
fun dividir(a:Float, b:Float):Float = a / b

fun imprimirDivisoria() = println("---------")
fun imprimirResultado(res:Float?) = println("resultado: " + res)

fun menu(x:Float, y:Float) {
    println("valores: " + x + ", " + y)
    println("opções:")
    println("1 - alterar valores")
    println("2 - somar")
    println("3 - dividir")
    println("4 - multiplicar")
    println("5 - subtrair")
    println("0 - sair")
    println(">digite o numero da opção:")
    val opcao:Int = readLine()!!.toInt()
    var res:Float? = null
    imprimirDivisoria()

    when(opcao) {
        0 -> println("saindo...");
        1 -> receberValores()
        2 -> res = somar(x,y)
        3 -> res = dividir(x,y)
        4 -> res = multiplicar(x,y)
        5 -> res = subtrair(x,y)
        else -> println("opcao invalida")
    }

    if (res != null) imprimirResultado(res)
}

fun receberValores() {
    println(">digite o primeiro numero:")
    var x:Float? = readLine()?.toFloat()
    println(">digite o segundo numero:")
    var y:Float? = readLine()?.toFloat()
    imprimirDivisoria()

    if (x == null || y == null) {
        println("ERRO: valor não pode ser nulo")
    } else {
        menu(x, y)
    }
}

fun main() {
    imprimirDivisoria()
    println("calculadora")
    imprimirDivisoria()
    receberValores()
}
