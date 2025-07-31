fun main() {
    var a: Int = 3
    var b: Int = 5
    val c = -5
    val d: Boolean = true
    println("a = $a, b = $b, c = $c, d = $d")

    // Arithmetic Operators: +, -, *, /, %
    println("\n--------------------")
    println("Arithmetic Operators:")
    println("a + b = ${a + b}") // or a.plus(b)
    println("a - b = ${a - b}") // or a.minus(b)
    println("a * b = ${a * b}") // or a.times(b)
    println("a / b = ${a / b}") // or a.div(b)
    println("a % b = ${a % b}") // or a.rem(b)

    // Relational Operators: ==, !=, <, <=, >, >=
    /*
    == -> a.compareTo(b) == 0 or a?.equals(b)?:(b === null)
    != -> a.compareTo(b) != 0 or !(a?.equals(b)?:(b === null)) > 0
    >, >= -> a.compareTo(b) >, >= 0
    <, <= -> a.compareTo(b) <, <= 0
    */
    println("\n--------------------")
    println("Relational Operators:")
    println("a == b: ${a == b}") // or a?.equals(b)?: (b === null), or a.equals(b)
    println("a.compareTo(c) == ${a.compareTo(c)}")
    // compareTo: 1 if greater, -1 if smaller, 0 if equal

    // Assignment Operators: =, +=, -=, *=, /=, %=
    println("\n--------------------")
    println("Assignment Operators:")
    var x = a
    x += 1
    println("a += 1: ${x}")

    // Unary Operators: +, -, ++, --
    println("\n--------------------")
    println("Unary Operators:")
    println("a++ = ${a++} // use value first, then increment a: a = $a")
    println("++a = ${++a} // increment first, the use value, a = $a")
    println("--a + a-- = ${--a + a--}") // 4 (a = 4) + 4 (then a = 3)

    // Logical Operators: &&, ||, !
    println("\n--------------------")
    println("Logical Operators:")
    println("d && true: ${d && true}")
    println("d || false : ${d || false}")
    println("!d : ${!d}")

    // Bitwise Operators:
    println("\n--------------------")
    println("Bitwise Operators:")
    // a = 3: 0011, b = 5: 0101, c = -5: 1011
    println("$a $b $c")
    // .and(), .or(), .xor(), .inv()
    // or: a and b, ...
    println("a.and(b) = ${a.and(b)}") // 0001 = 1
    x = a or b
    println("a or b = ${x}") // 0111 = 7
    // .shl(), .shr(), ushr()
    x = a shl 1
    println("a.shl(1) = ${x}") // 0110 = 6 (a*2)
    println("c.shr(1) = ${c.shr(1)}") // 1101 = -3
    println("c.ushr(1) = ${c.ushr(1)}")
    // 01111111 11111111 11111111 11111101 = 2147483645

    println("\n--------------------")
    println("#vduczz")
}
