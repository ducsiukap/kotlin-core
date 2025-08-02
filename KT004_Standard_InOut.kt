import java.util.Scanner
import kotlin.io.readLine

fun main() {

    // Output
    println("\n--------------------")
    println("Standard Output")
    // print() - this function prints the messages without "\n"(endl) at the end.file
    print("print()")
    print("print()")
    print("print()")
    // print()print()print()
    print("\n")
    // println() = print(message + "\n")
    println() // '\n'
    println("println()")
    println("println()")
    println("println()")
    // embedded variable into message with ${var_name}
    var name = "vduczz"
    println("Hi guys, im ${name}")

    // Input
    // Scanner class -> import java.util.Scanner
    println("\n--------------------")
    println("Standard input with Scanner class")
    val sc = Scanner(System.`in`)
    // sc.nextType() to get value of Type: Int, Byte, Boolean. Short, Long, Float, Double,
    // BigInteger, BigDecimal
    // sc.next() to get a word
    // sc.nextLine() to get a line of string
    print("Enter a number: ")
    val intNum: Int = sc.nextInt()
    sc.nextLine() // take the last '\n' of prev input
    // nếu nhập biến khác String trước khi nhập String,
    // cần loại bỏ '\n' trong bộ đệm bởi lần nhập trước
    print("Enter your name: ")
    name = sc.nextLine()
    println("Your name: ${name}")
    println("Your number: $intNum")

    // with readline() - read a line of string
    println("\n--------------------")
    println("Standard input with readLine() function")
    // use readLine()!! to ensure that the input value is not null
    // use readLine()!!.toType() to convert String to other type
    print("Enter your name: ")
    name = readLine()!!
    print("Enter your age: ")
    val age = readLine()!!.toInt() // cast String to Int
    println("Your name: $name")
    println("Your age: $age")

    println("\n--------------------")
    println("#vduczz")
}
