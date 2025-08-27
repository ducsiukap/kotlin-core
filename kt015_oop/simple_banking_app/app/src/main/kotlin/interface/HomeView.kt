class HomeView(u: User) {
    private val u = u

    fun show() {
        home@ while (true) {

            println("\n==============================\n")

            println("Welcome to SimpleBank!  (user: ${u.getName()}, ${u.getBalance()}$)")
            println("[1]. View Balance")
            println("[2]. Transfer Money")
            println("[0]. Logout")
            print("Please choice: ")
            val userChoice = readLine()!!

            println("\n==============================\n")

            when (userChoice) {
                "0" -> break@home
                "1" -> {
                    println("Waiting...")
                    BankMngDAO().getUserBalance(u)
                    println("Your balance: ${u.getBalance()}")
                }
                "2" -> {
                    // sorry because i forgot to add account_code =))
                    print("enter received id: ")
                    val toId = readLine()!!.toInt()
                    print("enter amount: ")
                    val amount = readLine()!!.toDouble()

                    println("Processing....")
                    val success = BankMngDAO().transfer(u, User(toId, "", "", "", null), amount)
                    println("Transfer Status: ${if (success) "Success" else "Fail"}")
                }
            }
        }
    }
}
