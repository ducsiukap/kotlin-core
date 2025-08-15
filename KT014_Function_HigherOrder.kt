fun minus(a: Int, b: Int): Int {
    return a - b
}
// Higher Order function:
// a function that accept other function (function, lamdas) as it's param or return value

// thường sử dụng để xử lý logic của chương trình

// example: a function is the param of other one
inline fun myCalculate1(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    val result = op(a, b)
    return result
}

// example: return other function
fun moduler(factor: Int): (Int) -> Int {
    val lambda = { number: Int -> number % factor }
    return lambda // for lambda, annonymous func
    // return ::normalFunction  //for normal function
}

fun main() {
    println("\n---------------Passing a function to other one---------------")
    // pass a function to a function
    // 1. lambda
    val add: (Int, Int) -> Int = { a, b -> a + b }
    // 2. annonymous function
    val mul = fun(a: Int, b: Int) = a * b
    println(">>> Sum of 3 and 5 is ${myCalculate1(3, 5, add)}")
    println(">>> Product of 3 and 5 is ${myCalculate1(3, 5, mul)}")
    // 3. normal function => using ::funcName
    println(">>> 3 minus 5 is ${myCalculate1(3, 5, ::minus)}")

    println("\n---------------Returning a function from other one---------------")
    val modBy10 = moduler(10)
    val modBy50 = moduler(50)
    val randNumber = (Math.random() * (1e9 + 7)).toInt()
    println("$randNumber mod 10 is ${modBy10(randNumber)}")
    println("$randNumber mod 50 is ${modBy50(randNumber)}")

    
    println("\n--------------------")
    println("#vduczz")
}
