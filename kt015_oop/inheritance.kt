// to make a class can be inherited by another,
// using `open` keyword
open class Person1(name: String?, age: Int) {
    var name: String = this.stdName(name ?: "annonymous")
        set(value) {
            field = this.stdName(value)
        }
    var age: Int = if (this.isValidAge(age)) age else 0
        set(value) {
            field = if (this.isValidAge(value)) value else 0
        }

    private fun isValidAge(age: Int) = (age >= 0) && (age <= 150)

    private fun stdName(name: String): String {
        val words = name.trim().split("\\s+".toRegex())
        val result = buildString {
            for (word in words) {
                append(word.substring(0, 1).uppercase())
                append(word.substring(1).lowercase())
                append(" ")
            }
        }
        return result.trimEnd()
    }

    // allow override function -> using open keyword
    open fun printInfo() {
        println(
                """Person {
        |   name: ${this.name},
        |   age: ${this.age}
        |}""".trimMargin()
        )
    }

    // with field, we can also allow subclass override it (get&set)
    // open var ...
}

// to inherit from another class -> using :
class Student1(name: String?, age: Int, studentId: String?) : Person1(name, age) {
    private val studentId = studentId ?: "############"

    // or using secondary constructor
    // constructor(name: String?, age: Int, studentId) : super(name, age ) { this.studentId =
    // studentId}

    // override function
    override fun printInfo() {
        println(
                """Student {
        |   studentId: ${this.studentId},
        |   name: ${this.name},
        |   age: ${this.age}
        |}""".trimMargin()
        )
    }

    // override field
    // overide var smth...
    // get()
    // set()
}

fun main() {
    val s1: Person1 = Student1("Pham van duc", 21, null)
    s1.printInfo()
    println(s1 is Student1)
    println(s1 is Person1)

    // to cast to another type -> using : as? => return null if cast fail
    val s2 = s1 as? Student1
    s2?.printInfo()
    println(s2 is Student1)
    println(s2 is Person1)

    println("\n--------------------")
    println("#vduczz")
}
