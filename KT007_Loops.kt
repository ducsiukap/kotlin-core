fun main() {
    // while loop
    println("\n--------------------")
    println("Count from 1 to 100 with while loop: ")
    var step: Int = 1
    while (step.compareTo(100) <= 0) {
        print("$step ")
        ++step
    }
    println()

    // do-while loop
    println("\n--------------------")
    println("Count from 1 to 100 with do-while loop: ")
    step = 1
    do {
        print("$step ")
        ++step
    } while (step <= 100)
    println()

    // for loop:
    // for in range: for (i in smaller..larger step(n)) or for (i in larger downTo smaller step n )
    println("\n--------------------")
    // smaller to larger with: start..end
    println("Count from 1 to 100, step = 1 with for-in-range loop: ")
    for (i in 1..100) print("$i ")
    println()
    // larger to smaller with: start downto end
    println("Count from 100 to 1, step = 3 with for-in-range loop: ")
    for (i in 100 downTo (1) step (3)) print("$i ")
    println()

    println("\n--------------------")
    // Traverse an array with for in array, string is similar
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // not using index
    println("Traversing array by for-in-array: ")
    for (number in numbers) print("$number ")
    println()
    // using index: arr.indices
    println("Traversing array using index by for-in-array: array.indices")
    for (index in numbers.indices) print("${numbers[index]} ")
    println()
    // with index: arr.withIndex()
    println("Traversing array with index by for-in-array: array.withIndex()")
    for ((index, number) in numbers.withIndex()) println("index : $index, number : $number")

    // for-in-collection

    println("\n--------------------")
    println("#vduczz")
}
