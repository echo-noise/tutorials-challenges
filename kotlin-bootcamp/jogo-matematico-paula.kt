fun main(args: Array<String>) {
    
    val N = readLine()!!.toInt()
    for (i in 1..N) {
        val linha = readLine()!!.toString()
        val N1 = Character.getNumericValue(linha[0])
        val letra = linha[1]
        val N2 = Character.getNumericValue(linha[2])
    
        if (N1 == N2) println(N1 * N2)
        else if (letra.isUpperCase()) println(N2 - N1)
        else println(N1 + N2)
    }
}
