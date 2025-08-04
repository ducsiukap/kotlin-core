fun main() {
    /* Syntax
    when (expression) {
        valueA1, valueA2, valueA3 -> {
            statements
        }
        valueB1 -> {
            statements
        }
        valueC1, valueC2 -> {
            statements
        }
        ...
        else -> {
            statements
        }
    }
    // phần else có thể được loại bỏ nếu value1, value2... bao hàm hết tất cả các giá trị có thể của expression
    */
    println("\n--------------------")
    println("when Expression")

    print("\nEnter a month: ")
    val month = readLine()!!
    println()

    // Using when to assign value for variable or as return value of function
    val monthStr =
            when (month) {
                "1" -> "January"
                "2" -> "February"
                "3" -> "March"
                "4" -> "April"
                "5" -> "May"
                "6" -> "June"
                "7" -> "July"
                "8" -> "August"
                "9" -> "September"
                "10" -> "October"
                "11" -> "November"
                "12" -> "December"
                else -> "###error"
            }
    /* note:
            - với những biểu thức when dùng để gán giá trị cho biến / làm kết quả trả về cho hàm
                 thì kiểu trả về ở mỗi nhánh phải giống nhau.
            - với nhánh có nhiều câu lệnh, đặt trong {} thì câu lệnh cuối cùng chính là giá trị trả về của nhánh
        * dùng when làm giá trị trả về cho hàm:
        fun functionName(args) {
            // statments
            return when(exp) {
                values -> {
                    statement
                    statement
                    statement // this is return of this branch
                }
                ...
                else {}
            }
        } -> kết quả trả về sẽ được quyết định bởi when
    */
    println("This month is $monthStr!")

    // Using when expression likely switch-case
    when (month) {
        "1", "3", "5", "7", "8", "10", "12" -> println("This month has 31 days!")
        "2" -> println("This month has 28 or 29 days!")
        "4", "6", "9", "11" -> println("This month has 30 days!")
        else -> println("###error")
    }

    // Using when replace for if - else if - else
    println()
    val num: Any = 5
    when {
        isOdd(5) -> println("$num is odd number!")
        isEven(5) -> println("$num is even number!")
        else -> println("wtf=))")
    }

    when (num) {
        is Int -> println("Its an Integer")
        is String -> println("Its a String")
        else -> print("Its other datatype")
    }

    println("\n--------------------")
    println("#vduczz")
}

fun isOdd(num: Int): Boolean {
    return (num and 1) == 1
}

fun isEven(num: Int): Boolean {
    return (num and 1) == 0
}
