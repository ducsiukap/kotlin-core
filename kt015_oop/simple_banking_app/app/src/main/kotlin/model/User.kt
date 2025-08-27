class User(id: Int?, name: String?, username: String, password: String, balance: Double?) {
    private var id: Int = id ?: 0
    private var name: String = this.stdName(name ?: "annonymous")
    private var username: String = username
    private var password: String = password
    private var balance: Double = balance ?: 0.0

    fun getName(): String = this.name
    fun getUsername(): String = this.username
    fun getPassword(): String = this.password
    fun getBalance(): Double = this.balance
    fun getID(): Int = this.id

    fun stdName(name: String): String {
        val words = name.trim().split("\\s+".toRegex())
        return buildString {
                    for (word in words) {
                        append(word.lowercase().replaceFirstChar { it.uppercaseChar() })
                        append(" ")
                    }
                }
                .trim()
    }
    fun setID(id: Int) {
        this.id = id
    }
    fun setName(name: String) {
        this.name = this.stdName(name)
    }
    fun setUsername(username: String) {
        this.username = username
    }
    fun setPassword(password: String) {
        this.password = password
    }
    fun setBalance(balance: Double) {
        this.balance = balance
    }
}
