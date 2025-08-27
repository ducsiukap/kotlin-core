// runtime polymorphism -> override
// -> read abstraction, inheritance

// compile-time polymorphism -> overrloading

// overloading:
// some fun has the same name, different least one below:
// - number of args -> can use varargs
// - return type
// - return type of arg

fun add(a: Int, b: Int): Int {
    return a + b
}

fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

fun add(a: Double, b: Double): Double {
    return a + b
}

fun add(vararg nums: Int): Int {
    var sum = 0
    for (num in nums) sum += num
    return sum
}

fun main() {
    println(add(2, 3)) // add(int, int)
    println(add(1, 2, 3, 4, 5)) // add(varargs)
    println(
            add(*intArrayOf(1, 2, 3, 4, 5, 6))
    ) // add(varargs) // * -> spread op -> convert arr to varargs
    println(add(2.0, 3.0)) // add(double, double)
    println(add(2, 3, 4)) // add(int, int, int)

    println("\n--------------------")
    println("#vduczz")
}
