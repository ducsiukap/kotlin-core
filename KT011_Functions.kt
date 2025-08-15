/* syntax to define a function
fun functionName(parameters: type) [: ReturnType] {
    // body
    [return returnValue]
}

- "fun" keyword: keyword for Function
- functionName: name of function
- parameters: dataType: the arguments of funtion that passed to the function
- returnType (option): type of returnValue (if not specified, function return "Unit")
*/

// user-defined function
fun helloUser(user: String) { // return Unit (or void in other programming language)
    println(">>> Welcome $user!")
}

// default args:
fun createUser(name: String = "vduczz", age: Int = 21, job: String = "$name's jobs") {
    // arg is assigned a default value
    // when function is called without passed some arg,
    // the default value is used
    println(
            """>>> Create a new User:
    |   Name: $name
    |   Age: $age
    |   Job: $job""".trimMargin()
    )
}

fun main() {
    println("\n--------------------")
    // types of function
    // 1. invoke a built-in function
    println(">>> max of (3, 5) is ${Math.max(3, 5)}") // println(), Math.max() is built-in function
    // 2. invoke a user-defined function
    helloUser("vduczz")

    println("\n--------------------")
    println("Named arguments")
    // Named argument: pass exactly argument using its name
    // => dont need similar order as defined
    // mixing named arg & positioned arg is not allowed
    createUser(age = 18, name = "Bong", job = "Student")
    createUser(job = "Developer", age = 21, name = "vduczz")

    println("\n--------------------")
    println("Default argument")
    createUser(age = 23)
    createUser()
    createUser(name = "Annonymous", age = 18, job = "Developer")

    println("\n--------------------")
    println("#vduczz")
}
