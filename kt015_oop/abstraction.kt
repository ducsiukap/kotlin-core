// abstract class:
// - cannot be instanced
// - contains  both abstract method and conrete method
// => normal class + abstract method

abstract class AbstractClass(naf: Int) {
    // can contain:

    // abstract + non-abstract fields
    abstract var abstractField: Int
    val nonabstractField: Int = naf // cannot be override, using open keyword to allow override

    // abstract + non-abstract methods
    abstract fun abstractMethod()
    fun nonabstractMethod() {
        println("HelloWorld!")
    }
}

// subclass must override all abstract members (methods, properties)
// may override open member
class SubClass(af: Int, naf: Int) : AbstractClass(naf) {
    override var abstractField: Int = af
        get() = field
        set(value) {
            field = value * 10
        }
    // val nonabstractField = naf; // cannot override

    override fun abstractMethod() {
        println("Implement abstractMethod()!")
    }
}

fun main() {
    val obj = SubClass(100, 200)
    obj.abstractField = 100 // 1000
    println("obj.af:  ${obj.abstractField}")
    println("obj.naf: ${obj.nonabstractField}")

    obj.abstractMethod()
    obj.nonabstractMethod()

    println("\n--------------------")
    println("#vduczz")
}
