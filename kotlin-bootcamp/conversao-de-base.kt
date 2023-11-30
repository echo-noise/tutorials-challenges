fun main(args: Array<String>) {
	val r = """0x.*""".toRegex()
	
	while(true) {
		var input = readLine()!!.toString()

		if (r.matches(input)) {
			println(input.removePrefix("0x").toInt(16))
		} else if (input.toInt() > 0 && input.toInt() < Integer.MAX_VALUE) {
			println("0x".plus(Integer.toHexString(input.toInt()).toUpperCase()))
		} else {
		  break
		}
	}
}
