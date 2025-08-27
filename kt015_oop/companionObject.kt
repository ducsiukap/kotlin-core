// companion object -> static members in java
class User1(name: String) {

    init {
        countUser++
    }

    companion object {
        // static data members
        var countUser = 0

        // static method

    }
    // => this is Companion object
    // we can named it
    // ex :
    // companion object Vduczz {}

    // access via className or companion name
    // ex:
    // User1.countUser
    // User1.Companion.countUser
    // or if you're named the companion as Vduczz
    // User1.Vduczz.countUser
}

fun main() {
    val vduczz = User1("vduczz")
    for (i in 0..5) User1("abc")
    print(User1.Companion.countUser) // or User1.countUser is Ok
    // 7

    println("\n--------------------")
    println("#vduczz")
}
