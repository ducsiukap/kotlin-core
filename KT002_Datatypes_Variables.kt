// Variables
// two types of Kotlin variables
// Mutable variables: can be reassigned, declared with 'var'
// Immutable variables: cannot be reassigned, declared with 'val' (likely const)
/* syntax to declare a variable:
    val/var varName[: Datatype] = value
- datatype có thể được suy luận thông qua giá trị khởi tạo
- value: giá trị khởi tạo là bắt buộc

- nullable variable: làm cho biến có thể nhận giá trị null
    + bắt buộc phải chỉ định datatype => sử dụng dấu hỏi (?) sau tên datatype
    + syntax: var/val varName: Datatype?[ = value]
*/
fun main() {
    /* Integer
    - Byte: 8-bits signed integer
    - Short: 16-bits signed integer
    - Int: 32-bits signed integer
    - Long: 64-bits signed integer, suffix: L or l
     */
    val intVal = 123 // immutable
    var longVar: Long = 123L // mutable
    println("intval: $intVal, longVar: $longVar")
    // intVal = 456 // error
    // longVal = 456L // ok

    /* Floating-Point
    - Float: 32-bits floating-point number, suffix: F or f
    - Double: 64-bits floating-point number, suffix: D or d
    */
    val floatVal: Float = 123.45f
    println("floatVal: $floatVal")

    // Boolean: 1 bit, true or false

    // Char : 16-bits unicode character
    val charVal: Char = 'D'
    println("charVal: $charVal")

    // String: sequence of characters
    val myName: String = "vduczz"
    println("hi guys, i'm: $myName")

    // Array: collection of same type elements
    // Any: superclass of all types in Kotlin, can hold any
    var anyVal: Any = 1
    println("anyVal: $anyVal")
    anyVal = "a string"
    println("anyVal: $anyVal")

    // Unit: likely 'void' datatype
    // Some more complex datatypes: List, Set, Map, class, ...

    println("--------------------")
    /* handle nullable variable
    - declare:  var/val varName: Datatype? = value

    - safe call operator: ?. -> check biến trước khi truy cập thuộc tính
        ex: user?.name -> return null (if user is null) or user.name
    - elvis operator: ?: -> check giá trị biến
        ex: variable ?: defaultValue -> return defaultValue (if variable is null) or variable
    - not-null assertion: !! -> bỏ qua kiểm tra null, throw NullPointerException nếu biến là null
        ex: variable!!.property
        -> chỉ sử dụng !! khi chắc chắn biến không null

    * note: nullable variable must be handled with ?., ?: or !! before using it
    => !! chỉ giúp viết ngắn gọn hơn so với ?. và ?:, nhưng không an toàn
        và chỉ nên sử dụng khi chắc chắn biết biết không phải null
    */
    var username: String? = null // nullable variable
    // val helloUser: String = "Hello, ${username.uppercase()}!" // error, need to handle null
    val helloUser: String = "Hello, ${username?.uppercase()}!" // safe call -> Hello, null!
    val helloGuest: String = "Hello, ${username ?: "Guest"}!" // elvis operator -> Hello, Guest!
    println(helloUser)
    println(helloGuest)

    // val hello: String ="Hello, ${username!!.uppercase()}!" // -> throw NullPointerException
    // because username is null

    // username = "vduczz"
    // val hello: String = "Hello, ${username!!.uppercase()}!" // ok
    // println(hello)

    println("\n--------------------")
    println("#vduczz")
}
