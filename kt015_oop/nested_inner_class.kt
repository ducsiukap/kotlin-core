class Outer(var outerField: Int) {

    // likely static nested class in java
    // cannot access outer non-static properties
    class Nested {
        // val innerField: Int = outerField // error
        // val innerField:Int = staticOuterField
        fun get(): Int {
            val rand = (Math.random() * 1000 + 1).toInt()
            println("get `$rand` from Nested!")
            // outer field = rand -> error
            return rand
        }
    }

    // likely non-static nested class in java
    // accessable to the outer properties
    inner class Inner {
        fun get(): Int {
            val rand = (Math.random() * 1000 + 1).toInt()
            println("get `$rand` from Inner!")
            return rand
        }

        fun accept(value: Int? = null) {
            val accepted = value ?: get()
            println("Accept $accepted from Inner!")
            outerField = accepted // ok
        }
    }
}

fun main() {

    println("\n--------------------")
    // to access Nested, Inner member -> create object
    val out = Outer(0)

    // create nested classs instance via classname
    val nested = Outer.Nested()
    for (i in 0..5) nested.get()

    //  create inner class instance via outer class instance
    val inner = out.Inner()
    println("\nout.outerFiled: ${out.outerField}\n")
    inner.accept()
    println("out.outerFiled: ${out.outerField}\n")

    inner.accept(nested.get())
    println("out.outerFiled: ${out.outerField}")

    println("\n--------------------")
    println("#vduczz")
}
