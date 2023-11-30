import java.io.EOFException
import java.lang.Exception


fun main(args: Array<String>) {
    
    while (true) {
    
        try {
        
            val l = readLine()!!.toInt()
            val v = readLine()!!.split(" ").run { map { it.toInt() }.toIntArray() }
            v.sort()
            
            when(v.last()) {
              in 0..9 -> println(1)
              in 10..19 -> println(2)
              else -> println(3)
            }
    
        } catch (f : EOFException ) {
            break
        } catch (n : NumberFormatException) {
            break
        } catch (e : Exception) {
            break
        }
    }
}
