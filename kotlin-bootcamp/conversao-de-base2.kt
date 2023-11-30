import kotlin.math.pow

val valoresHex = mapOf(10 to 'A', 11 to 'B', 12 to 'C', 13 to 'D', 14 to 'E', 15 to 'F')

fun hexadecimalParaDecimal(valor: String): Int {
    val string = valor.removePrefix("0x").reversed()
    var cont = 0.0
    var num: Int
    var res = 0

    for (ch in string) {
        if (ch.isDigit()) { num = Character.getNumericValue(ch) }
        else { num = valoresHex.filter { it.value == ch.toUpperCase() }.keys.first() }

        res += (num * 16.0.pow(cont)).toInt()
        ++ cont
    }

    return res
}

fun decimalParaHex(numero: Int): String {
    var res = "0x"
    when (numero) {
        in 0..10 -> return res.plus(numero.toString())
        in 10..15 -> return res.plus(valoresHex.get(numero))
        else -> {   val arr = arrayListOf<Int>()
            var n = numero.toDouble()
            while(n / 16 >= 1) {
                arr.add((n % 16).toInt())
                n /= 16
            }
            arr.add(n.toInt())
            arr.reverse()

            for (x in arr) {
                if (x < 10) {
                    res += x.toString()
                } else {
                    res += valoresHex.get(x)
                }
            }
            return res
        }
    }
}

fun main(args: Array<String>) {
	val r = """0x.*""".toRegex()
	
	while(true) {
		var input = readLine()!!.toString()

		if (r.matches(input)) {
		  println(hexadecimalParaDecimal(input))
		} else if (input.toInt() > 0 && input.toInt() < Integer.MAX_VALUE) {
			println(decimalParaHex(input.toInt()))
		} else {
		  break
		}
	}
}
