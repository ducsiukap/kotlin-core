import kotlin.math.sqrt // Extension Function : add new function to existing class, dont need to

// modifying them

// syntax: fun className.functionNam() {}
fun Number.isqrt(): Int {
    return Math.sqrt(this.toDouble()).toInt()
}

class MyMath1 {
    companion object Vduczz {}
}

fun MyMath1.square(n: Number) = n.toDouble() * n.toDouble()

fun MyMath1.isquare(n: Number) = MyMath1().square(n).toInt()

//  add to Companion Object
fun MyMath1.Vduczz.isqrt(n: Number): Int = Math.sqrt(n.toDouble()).toInt()

fun main() {
    println(30.isqrt())
    println(1000.isqrt())
    println(15.2.isqrt())

    println()
    val math = MyMath1()
    println(math.square(30))
    println(math.square(40.5))
    println(math.isquare(40.5))

    println()
    println(MyMath1.Vduczz.isqrt(30))

    println("\n--------------------")
    println("#vduczz")
}
