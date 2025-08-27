class mainMenu {

    fun show() {
        login@ while (true) {
            println("\n=======================================\n")

            println("Welcome to SimpleBank!")
            println("[1]. Login")
            println("[2]. Create Account")
            println("[0]. Exit")
            print("Please choice: ")
            val userChoice = readLine()!!

            println("\n=======================================\n")

            when (userChoice) {
                "0" -> break@login
                "1" -> {
                    print("username: ")
                    val username = readLine()!!
                    print("password: ")
                    val password = readLine()!!

                    val user = User(null, null, username, password, null)
                    print("checking....")

                    val success = UserDAO().checkLogin(user)
                    println("Login status: ${if (success) "Success" else "Failed"}")
                    if (success) HomeView(user).show()
                }
                "2" -> {
                    print("your name: ")
                    val name = readLine()!!
                    print("username: ")
                    val username = readLine()!!
                    print("password: ")
                    val password = readLine()!!

                    val user = User(null, name, username, password, null)
                    println("Processing...")

                    val success = UserDAO().addUser(user)
                    println("Register status: ${if (success) "Success" else "Failed"}")
                    if (success) HomeView(user).show()
                }
                else -> println("Invalid input. Please try again!")
            }
        }
    }
}
