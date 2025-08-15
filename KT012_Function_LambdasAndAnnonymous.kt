fun main() {
    // both lambdas expression and annonymous function is Function literals
    // Function literal: function is not declared, no-name and using as an expression (can be
    // assigned into a variable)

    // Lambda expression
    println("\n---------------Lambdas Expression---------------")
    // syntax to define a lambda:
    // val lambda_name : (Type1, Type2, ..., TypenN) -> Type = (a, b, ... n -> body)
    val add: (Int, Int) -> Int = { a, b -> a + b }
    // or:
    // va. lambda_name = {a: Type, b: Type, ... , n:Type -> code}
    val mul = { a: Int, b: Int -> a * b }

    // invoke lambda exp:
    println("Sum of 3 and 5 is ${add(3, 5)}")
    // or using .invoke
    println("Product of 3 and 5 is ${mul.invoke(3, 5)}")

    /* NOTE: Return value of lambda expression:
    - if return type of lambda is not Unit, the last statement inside lambda exp is treated as return  value
    val lambdaexp = {args: type ->
        statement
        statement
        statement
        ....
        statement // <- return type
    }
    */

    // In most of cases lambdas contains the single parameter
    // using "it" to represent that parameter => {do_smth_with_it}

    // use lambda to create
    println(">>> create IntArray using lambdas exp")
    val intArr =
            IntArray(5) {
                println("\tindex:  $it")
                it + 1 // <= return value of this lambda exp
            }
    // print IntArr
    print(">>> print IntArray using lambdas exp: ")
    intArr.forEach { print("$it ") }
    println()

    /* using lambda as class extension:
    syntax:
        val lambda = ClassName.(Type) -> returnType = {
                        // "this" for ClassName instance
                        // "it" for passed parameter (Type)
                    }

        // using:
        val obj = ClassName()
        obj.lambda()
    */
    // example:
    val concat: String.(String) -> String = { this + " " + it }
    println(">>> ${"hi".concat("guys!")}") // >>> hi guys!

    // annonymous function
    println("\n---------------Annonymous Functions---------------")
    // annonymous function is very similar with the normal function
    // except it's not has a specific name

    // thường được gán vào biến hoặc truyền đối số cho hàm bậc cao hơn
    // hữu ích khi cần chi tiết hơn so với lambda,
    // có thể sử dụng "return"

    // Syntax to define an annonymous func:
    // fun(params: type) : returnType = exp
    val add2 = fun(a: Int, b: Int): Int = a + b
    // or // fun(params: type) : returnType {code-block}
    val mul2 =
            fun(a: Int, b: Int): Int {
                return a * b
            }
    // call annonymous func
    println("Sum of 10 and 20 is ${add2.invoke(10, 20)}")
    println("Product of 10 and 20 is ${mul2(10, 20)}")

    println("\n--------------------")
    println("#vduczz")
}
