// => hide the data, show only what is necessary
//  => private set (and get if it's needed)
class Person {
    // with sensitive data that cannot be read outside the class
    // -> it must be private
    // with normal data, we can public it and use private set
    private var personalId: String? = null
    var name: String? = null
        private set
    var age: Int = 0
        private set

    // or, we dont need make data becom private
    // just change how does get and set work
    /*example
    var publicSinsitiveData = ........
        get() = field  // return value of this field
        -> get() = null, get() = "#####"

        set(value) {
            field = .... -> set field's value
            -> validate value
            -> do nothing
            -> ...
        }
     */

    // use private set to avoid unauthorized modify the data
    // or validate the data
    // or ...

    constructor(personalId: String = "null", name: String = "null", age: Int = 0) {
        this.personalId = personalId
        this.name = this.stdName(name)
        this.age =
                when {
                    this.isValidAge(age) -> age
                    else -> 0
                }
        println("Create a new person: $this")
    }

    // validate name
    private fun stdName(name: String): String {
        val words = name.trim().split("\\s+".toRegex())

        val result = buildString {
            for (word in words) {
                append(word.substring(0, 1).uppercase())
                append(word.substring(1).lowercase())
                append(" ")
            }
        }
        println(">>> Standardized name: $result")
        return result.trim()
    }

    // validate age
    private fun isValidAge(age: Int): Boolean {
        if (age < 0 || age > 150) {
            println(">>> Crazy age: $age")
            return false
        } else return true
    }

    // validate personalId, ...

    // write function to set name, age, personalId
    fun setPersonalId(personalId: String) {
        // validate ?
        this.personalId = personalId
        println("set personal ID: ${this.personalId}")
    }
    fun setName(name: String) {
        this.name = this.stdName(name)
        println("set name:  ${this.name}")
    }
    fun setAge(age: Int) {
        this.age =
                when {
                    this.isValidAge(age) -> age
                    else -> 0
                }
        println("set age: ${this.age}")
    }

    //
    override fun toString(): String {
        return """Person {
        |   personalId: ${this.personalId},
        |   name: ${this.name},
        |   age: ${this.age}
        |}""".trimMargin()
    }
}

fun main() {
    println("\n--------------------")

    // create a new person
    val vduczz = Person(name = "Pham Van Duc", personalId = "000000000000", age = 20)

    // stdname
    vduczz.setName("kotlin java")
    println()

    // validate age
    vduczz.setAge(-1)
    vduczz.setAge(200)
    vduczz.setAge(21)
    println()

    println(vduczz)

    println("\n--------------------")
    println("#vduczz")
}
