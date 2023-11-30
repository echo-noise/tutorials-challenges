fun main(args: Array<String>) {
    
    val lista = mutableListOf<Int>()
    
    for (i in 1..readLine()!!.toInt()) {
        val input = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        input.sort()
        lista.add(mdc(input.elementAt(0), input.elementAt(1)))
    }
    lista.forEach {
      println("$it\n")
    }
}

// máximo divisor comum (chamada recursiva)
fun mdc(n1: Int, n2: Int): Int {
   val resto = n1 % n2
   if (resto == 0) { return n2 }
   else { return mdc(n2, resto) }
}
