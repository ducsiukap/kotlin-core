inline fun add(a: Int, b: Int, lambda: (Int, Int) -> Int) {
    val sum = lambda(a, b)
    println(">>> Sum of $a and $b is $sum")
}

// for infix function
class checkDatatype {
    infix fun check(param: Any): Any {
        return when (param) {
            is Int -> "Integer"
            is String -> "String"
            is Double -> "Double"
            else -> "Invalid"
        }
    }
}

fun main() {
    // Inline function
    println("\n---------------Inline Function---------------")
    /*
    - Normal function, lambda, annonymous, higher-oder function, ... is objects
        => use memory & slow down program
    - Inline Function: function declared with "inline" keyword
        => program does not need to separate memory for this function,
        this block of code is copies directly into where its invoked.
        => faster but make the source more complex
    *read more: https://www.geeksforgeeks.org/kotlin/kotlin-inline-functions/
    */
    add(3, 5, { a, b -> a + b }) // no function is called
    /* the below statements is pasted at everwhere add() is called:
    val sum = a + b
    println(">>> Sum of $a and $b is $sum")
    */

    // Infix function
    println("\n---------------Infix function---------------")
    // rather than call method from object likely: object.method(param)
    // we can also use: "object method param"

    // condition of a infix function:
    // 1. function must belong to a class
    // 2. has only one param
    // 3. using "infix" keyword

    val chkObj = checkDatatype()
    println("${chkObj check 30}")
    println("${chkObj check "vduczz"}")
    println("${chkObj check 0.0}")
    println("${chkObj.check(arrayOf(1, 2, 3))}")

    println("\n--------------------")
    println("#vduczz")
}
