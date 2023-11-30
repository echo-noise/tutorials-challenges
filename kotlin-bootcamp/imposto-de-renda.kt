fun main(args: Array<String>) {
    fun Float.format(digits: Int) = "%.${digits}f".format(this).replace(',','.')
    val r = readLine()!!.toFloat()
    var i = 0F
    var a:Float
    var b:Float
    var c:Float
    
    if ( r <= 2000 ) {
        i = 0F
    } else if ( r <= 3000) {
        i = (r - 2000) * 0.08F
    } else if ( r <= 4500 ) {
        a = r - 3000 
        b = r - 2000 - a

        i = (a * 0.18F) + (b * 0.08F)
    } else if (r > 4500) {
        a = r - 4500
        b = r - a - 3000
        c = r - a - b - 2000 
        
        i = (0.28F * a) + (0.18F * b) + (0.08F * c)
    }
    if (i == 0F) println("Isento") else println("R$ ${i.format(2)}")
}
