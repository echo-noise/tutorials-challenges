fun main() {
 for (i in 1..readLine()!!.toInt()) {
    val input = readLine()!!.split(" ").map { it.toInt() }
    if (input.size == 2) {
      println(input[0] + input[1])
    }
  }
}
