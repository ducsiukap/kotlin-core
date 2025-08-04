fun main() {
    /* if - else expression
        if (condition-1) {
            code-block1
        } else if (condition-2) {
            code-block2
        } else if (condition-3) {
            code-block3
        } else if ... {
            ...
        } else {
            default-code-block
        }

        => if condition-1 is true -> executes code-block1
        else if condition-2 is true -> executes code-block2
        else if ...
        else executes default-code-block

        - one if-else expression can have only if or if-else or all of if-elseif-else
    */
    println("\n--------------------")
    println("If-else Expression")

    print("Enter a month: ")
    val month = readLine()!!

    if (month.equals("1") ||
                    month.equals("3") ||
                    month.equals("5") ||
                    month.equals("7") ||
                    month.equals("8") ||
                    month.equals("10") ||
                    month.equals("12")
    ) {
        println("This month has 31 days!")
    } else if (month.equals("2")) {
        println("This month has 28 or 29 days!")
    } else if (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")) {
        println("This month has 30 days!")
    } else {
        println("Its not a valid month!")
    }

    println("\n--------------------")
    println("#vduczz")
}
