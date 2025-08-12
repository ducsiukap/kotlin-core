fun main() {
    // Array - one of the most fundamental data structures in practically all programming languares
    // contignuous memory, mutable, fixed size & index-based accessing

    // declare an array
    // 1. using arrayOf(element), arrayOf<Type>(elements)
    var arr1 = arrayOf(1, 2, 3, 4, 5)
    // 2. using Array constructor: Array(size, initValue(index))
    val arr2 = Array(5, { i -> i + 1 }) // lambda expression,
    // references:https://www.geeksforgeeks.org/kotlin/kotlin-lambdas-expressions-and-anonymous-functions/
    // 3. typeArrayOf(element)
    val arr3 = intArrayOf(1, 2, 3, 4, 5) // similar to arrayOf<Int>(1, 2, 3, 4, 5)

    println("\n--------------------")
    // accessing element
    print(">>> arr1: ")
    for (index in arr1.indices) print("${arr1.get(index)} ") // via .get(index)
    println()
    print(">>> arr2: ")
    for (index in arr2.indices) print("${arr2[index]} ") // via [index] operator
    println()

    println("\n--------------------")
    // modifying
    println("<<< set arr1 at index 0 = 100")
    arr1.set(0, 100) // via .set(index, newValue)
    println("<<< set arr1 at index 1 = 200")
    arr1[1] = 200 // via [index] operator
    for (number in arr1) print("$number ")
    println()

    println("\n--------------------")
    // traversing
    // for (value in arr) (KT007)
    // for (index in arr.indices) (KT007)
    // for ((index, value) in arr.withIndex()) (KT007)
    print(">>> traversing arr3 using forEach: ")
    arr3.forEach { value -> print("$value ") }

    println("\n--------------------")
    println("#vduczz")
}
