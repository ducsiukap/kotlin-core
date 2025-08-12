fun main() {
    // Array of character -> String
    // immutable -> cannot change the element & size

    println("\n--------------------")
    // declare a string
    val myName = "vduczz" // literal
    // or: val myName:String = vduczz
    // or: var myName = String() for empty String // String object

    // to print a string:
    println("my name is: $myName")

    // accessing element
    println("\n--------------------")
    println("Accessing element: ")
    println("myName[0]: ${myName[0]}") // via [index] operator
    println("myName.get(0): ${myName.get(0)}") // use .get(index) method

    println("\n--------------------")
    println("Iterating over the String: ")
    // iterating over the String
    // for (index in myName.indices)
    // for (character in myName)
    for ((index, character) in myName.withIndex()) {
        println("at index=$index, character=$character")
    }

    // String template:
    println("\n--------------------")
    println("String template: ")
    print("Enter your name: ")
    val yourName: String = readLine()!!
    print("Enter your age: ")
    val age: Int = readLine()!!.toInt()
    // embedd variable/value into String, using prefix "$"
    // => "your String ${your_variable_or_value}"
    println("Hello $yourName!")
    println("Your age is $age year olds!")

    // some important properties/methods of String;
    println("\n--------------------")
    println("Your name has ${yourName.length} characters") // String.length
    // String.subSequence(fromIndex, toIndex)
    val isSimilar =
            when {
                myName.compareTo(yourName) == 0 -> "equal"
                // compareTo() -> int
                else -> "not equal"
            }
    println("Your name is $isSimilar to my name, haha=)")

    // Raw string - multi-lines string
    println("\n--------------------")
    println("Raw (multi-lines) String: ")
    val myStr = """This is
    |multi-lines
    |String""".trimMargin()
    println(myStr)

    println("\n--------------------")
    // String equality
    // str1 == str2 -> true if the content is similar
    // str1 === str2 -> true if refer to the same string in String pool
    /* String pool:
    - khi 1 chương trình chạy, JVM tạo 1 string pool để lưu các string,
    khi 1 string được chạy, JVM kiểm tra xem liệu trong String pool liệu có tồn tại chưa
            + đã tồn tại => gán địa chỉ của String đó trong string pool cho biến
            + chưa tồn tại => tạo mới 1 địa chỉ trong string pool để lưu string đó
    => mục đích tăng tốc độ
    */
    val myName2 = "test" // "test" is not already existed in String pool
    val myName3 = "vduc" + "zz" // "vduczz" is already existed in String pool
    val myName4 = String("vduczz".toCharArray())

    println("Structural Equality: ")
    println(myName == myName2) // vduczz == test => false
    println(myName == myName3) // vduczz == vduczz => true
    println("Referential Equality: ")
    println(
            myName === myName2
    ) // "vduczz" has the same address in String pool with "test" ? => false
    println(myName === myName3) // true
    println(myName === myName4) // false (literal vs String object)

    /* Escape Characters
    - \" for double quote
    - \n for new line
    - \' for single quote
    - \\ for backslash
    - \t for tab
    - \b for backspace
    */

    println("\n--------------------")
    println("#vduczz")
}
