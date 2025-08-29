// map and collection - 2 main root of all collection in kotlin collection
/*
 - Collection:
Iterable<T> (root, I)
    |___ Collection<T> :  immuatble (read-only)
            |__ List -> listOf()
            |__ Set -> setOf()
    |___ MutableCollection (mutable)
            |__ MutableList -> mutableListOf() / arrayListOf()
            |__ MutableSet -> mutableSetOf() / hashSetOf()
* ArrayList, HashSet, LinkedHashSet is mutable

 - Map:
    Map<K, V> (read-only) -> mapOf(k1 to v1, k2 to v2, ...)
    MutableMap<K, V> -> mutableMapOf() / hashMapOf()
* HashMap, LinkedHashMap is mutable
*/

fun main() {
    // Immutable Collection/Map
    println("\n--------------------")
    val list1 = listOf(1, 2, 3, 4, 5)
    val map1 = mapOf(1 to "vduczz", 9 to "test", 4 to "abc")

    // cannot change the collection
    // list1.add(8) // error

    println("list1: $list1")
    println("map1: $map1")

    // Mutable collection
    println("\n--------------------")
    // using mutableListOf() / mutableSetOf() / mutableMapOf()
    var list2 = mutableListOf(1, 2, 3, 2, 1)
    // using class: ArrayList<T>, HashSet<T>, LinkedHashSet<T>, HashMap<T>, LinkedHashMap<T>
    var list3 = ArrayList<Int>(list2)

    println("list2: $list2")
    println("list3: $list3")
    println()

    // adding elem
    list2.add(-1)
    list3.add(100)

    // modifying
    list2.set(0, 99)

    println("list2: $list2")
    println("list3: $list3")

    println("\n--------------------")
    println("#vduczz")
}
