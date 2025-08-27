// -> what we can see about (define) object of this class
// -> ex: how we can specify a dog is a dog ? =)))

// access modifier
// order: public, internal, protected, private

// public: from anywhere
// internal: same module (module contains packages, files, ... or canbe project)
// protect: within class and subclass
// private: within class

// class -> public, internal, private
// public is default access modifier

class accessModifier {

    // getter and setter
    // when a field is declared, the getter (and setter) for it will be automatically created too
    // val-variable -> getter
    // var-variable -> getter & setter
    // access modifier is similar with modifier of field.

    var publicField: Int = 0 // public is default=
        // public set&get
        // we can change the access modifier of set (equal or less access modifier than original)
        internal set // setter is internal, not public
    protected var protectedField: Int = 0
    internal var internalField: Int = 0
    private var privateField: Int = 0
    // -> with private/protected field -> sometime, we maybe need to create public getter&setter
    fun getPF(): Int {
        return this.privateField
    }
    fun setPF(pf: Int) {
        this.privateField = pf
    }
}

// 3 ways to create a class

// 1st:  using Primary constructor
class Dog_1(var name: String, var hairColor: String) {
    // so, Kotlin automatically creates a constructor: Dog(name, hairColor) \

    // init block: -> call automatically  when an object is createed
    init {
        println("an object of Dog_1 is created!")
    }

    // declare some other fields
    var age: Int = 0

    // define secondary constructor
    constructor(
            name: String,
            hairColor: String,
            age: Int
    ) : this(name, hairColor) { // call primary constructor
        this.age = age
    }

    fun makeSound() {
        println("${this.name} says: Gau Gau!")
    }

    override fun toString(): String {
        return """Dog {
        |   name: ${this.name},
        |   hairColor: ${this.hairColor},
        |   age: ${this.age}
        |}""".trimMargin()
    }
}

// 2nd ways: create without using primary constructor
// class Dog_2 {
//     // body
// }

// 3rd ways: Empty class
// usage:
// - marker/placeholer -> ex: class ImportantClass,
// - define a new Type (generic)
// - empty  super class
//  ...

fun main() {
    // to create an object of a class
    //  val/var obj = className(args)

    println("\n---------------Access Modifiers---------------")
    val am = accessModifier()
    // call setter // only public, internal set can be invoked
    am.publicField = 1000
    am.internalField = 999
    // call getter
    println("public field: ${am.publicField}")
    println("internal field: ${am.internalField}")
    // println("protected field: ${am.protectedField}") // error
    // println("private field: ${am.privateField}") // error
    println("private field: ${am.getPF()}")

    // Object
    println("\n---------------Create object of class---------------")
    val bong = Dog_1(name = "Bong", hairColor = "white") // using primary  consturctor
    val eu = Dog_1("Eu", "yellow", 11) // secondary constructor

    println(bong)
    println(eu)

    // is operator -> Object is instanceof class
    println("\nbong is Dog: ${bong is Dog_1}")
    println("eu !is Dog: ${eu !is Dog_1}")

    // access to the class members (only public/internal can be access outside class) via dot (.)
    println()
    bong.makeSound()
    eu.makeSound()

    // create annonymous object
    println("\n---------------Create annonymous object---------------")
    val bong2 =
            object {
                // fields
                var name: String = "Bong"
                val hairColor = "black-white"
                // -> getter&setter is created automatically

                // method
                override fun toString(): String {
                    return """object {
                    |   name: ${this.name},
                    |   hairColor: ${this.hairColor}
                    |}""".trimMargin()
                }

                // cannot contains constructor
            }

    // call getter&setter
    bong2.name = "Bong version2"
    println("bong2.name: ${bong2.name}")

    println(bong2)

    println("\n--------------------")
    println("#vduczz")
}
