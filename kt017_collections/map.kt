fun main() {
    val map =
            mapOf(
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
                    (Math.random() * 99 + 1).toInt() to (Math.random() * 1000 + 100).toInt(),
            )

    // attributes
    println("\n--------------------")
    // .keys, .values, .entries -> get list of key / value/ (key and value)
    // .size
    println(">>> entries: ${map.entries}\n")

    // common methods
    println("\n--------------------")
    // .containsKey() / .containsValue()
    println("${map.containsKey( (Math.random()*99+1).toInt())}\n")
    // get(key) or map[key]
    // getOrDefault(key, defaultValue)
    // getOrElse(key) { defaultValue}
    val key = (Math.random() * 99 + 1).toInt()
    println(
            map.getOrElse(key) {
                println("not found key")
                -1 // returnValue
            }
    )
    println()
    // .filterKeys{}
    // .filterValues {}
    println("${map.filterKeys { it >= 50 }}\n")
    // transform key or value
    // .mapKeys {}
    // .mapValues {}

    // Modifying map (for mutable)
    println("\n--------------------")
    val mmap = HashMap(map)
    println(">>> $mmap\n")
    // adding elem
    mmap.put(-99, -999)
    mmap.putAll(mapOf(-1 to -2, -2 to -3))
    println(">>> $mmap\n")
    // remove item
    mmap.remove(-1)
    println(">>> $mmap\n")
    // replace item
    mmap.replace(-2, -100)
    println(">>> $mmap\n")

    println("\n--------------------")
    println("#vduczz")
}
