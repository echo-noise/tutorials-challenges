fun primos (num: Double) : Boolean {
  if(num < 2.0) { return false }
  if(num <= 3.0) { return true }
  if(num % 2.0 == 0.0 || num % 3.0 == 0.0) { return false }
  
  var i = 5.0
  while(i*i <= num) {
    if(num % i == 0.0 || num % (i + 2.0) == 0.0) {
      return false
    }
    i += 6.0
  }
  return true
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var num : Double
    
    if(n != null) {
      for ( i in 1..n ) {
        num = readLine()!!.toDouble()
        if(num != null) {
          if(primos(num)) {
            println("Prime")
          } else {
            println("Not Prime")
          }
        }
      }
    }
}
