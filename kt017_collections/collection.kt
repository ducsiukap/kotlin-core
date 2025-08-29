// for List, Set

fun main() {

    // Creating
    println("\n--------------------")
    // create immutable list:
    // via listOf(varargs elems)
    // via List<T>(size, init)
    val imList = List<Int>(10, { (Math.random() * 100 + 1).toInt() })

    // create mutable list:
    // via mutableListOf(varargs elems) / mutableSetOf(varargs elems) / arrayListOf(varargs elems)
    // via ArrayList<T>(), HashSet<T>(), LinkedHashSet<T>()
    val mList = ArrayList<Int>(imList.shuffled()) //
    // ArrayList<T>()
    // ArrayList<T>(size)
    // ArrayList<T>(Collection o)

    println(">>> immutable list: $imList")
    println(">>> mutable list: $mList")

    // Common methods
    println("\n--------------------")
    // .size()
    // .isEmpty() / .isNotEmpty()
    // contains(elem) / containsAll(collection)
    var test = listOf(3, 13)
    println(">>> ${imList.containsAll(test)} - ${mList.containsAll(test)}\n")

    // traversal:
    // for (item in lists)
    // .forEach(value->process)
    // .forEachIndexed(index, values -> process)

    // find and filter
    // .find{condition} -> return first object that matches the condition / null
    println(">>> first odd number in imList: ${imList.find{it and 1 == 1}}")
    println(">>> first odd number in mList: ${mList.find{it and 1 == 1}}\n")
    // first() / firstOrNull() / last() / lastOrNull()
    // filter{elem -> } / filterNot {elem -> } / filterIndexed{ index, elem -> }
    println(">>> all even number in imList: ${imList.filter{it and 1 == 0}}")
    println(">>> all even number in mList: ${mList.filterNot{ it and 1 == 1}}\n")
    // indexOf() / firstIndexOf() / lastIndexOf()

    // any { condition } : true if any elem in collection matches the condition
    // all { condition } : true if all elem match the condition
    // none { condition } : true if no elem match the condition
    println(">>> all elem in imList is odd: ${imList.all{it and 1 == 1}}")
    val isPrime =
            fun(n: Int): Boolean {
                for (i in 2..Math.sqrt(n * 1.0).toInt()) {
                    if (n % i == 0) return false
                }
                return n >= 2
            }
    println(">>> any elem in mList is prime number: ${mList.any{ isPrime(it) }}\n")

    // data transform
    // .map{ transformer } : List<T>
    println(">>> ${imList.map{ it*it }}")
    // .mapIndexed { index, elem -> } : List<T>
    // .flatMap { it.toList() } -> 1D arr
    // .mapNotNull { transformer } -> remove null after transfromed.
    val strList = listOf("Hello", "World")
    println(">>> .map{ it.toList() }: ${strList.map{ it.toList() }}")
    println(">>> .flatMap { it.toList() } : ${strList.flatMap { it.toList() }}\n")

    // sort : List<T>
    //  .sorted() / sortedDecending()
    // .sortedBy { it.abcde } // criteria of it
    // .reversed()
    // .shuffled()
    println(">>> imList.sorted(): ${imList.sorted()}")
    println(">>> imList: ${imList}\n")

    // math
    // .count() / count { filter }
    // .sum() / .sumOf { it.abc }
    // .average() /
    // .min() / .minBy { it.abc } / .max() / .maxBy { it.abc }
    println(">>> Count prime numbers in mList: ${mList.count{ isPrime(it) }}\n")

    // union, intersection, ....
    // plus(collection) : List<T>
    println(">>> ${mList.plus(imList)}")
    // union() / intersection() / substract() : Set<T>
    // take(n) / drop(n) -> lấy / bỏ n phần tử đầu
    println(">>> ${imList.take(3)}")
    // chunked(n) -> chia nhóm n phần tử
    println(">>> ${mList.chunked(5)}\n")
    // groupBy { ... }
    // associateBy { it.abc } -> convert to map, key=it.abc

    // Mutable Collection methods
    //  modifying collection
    println("\n--------------------")
    println(">>> mList: ${mList}")
    // adding elems:
    // .add(elem) / add (index, elem)
    // .addAll(collection)
    mList.addAll(List<Int>(5, { it * -1 }))
    println(">>> mList: ${mList}\n")

    // accesing elem
    // .get()
    // .getOrNull()
    // .getOrElse()
    println(">>> ${mList.get(2)}\n")
    // immutable list can be accessing via [index] op.!

    // removing
    // .remove(elemment: T) / removeIf {}
    // .removeAll(elems)
    // .retainAll(elems)
    // .clear()
    mList.retainAll({ !isPrime(it) })
    println(">>> mList: ${mList}")
    // or using iterator
    val iter = mList.iterator()
    iter.next()
    iter.remove() // remove current value
    println(">>> mList: ${mList}\n")

    // modifying
    // .set(index, elem)
    mList.set(0, 100000)
    println(">>> mList: ${mList}\n")
    println("\n--------------------")
    println("#vduczz")
}
