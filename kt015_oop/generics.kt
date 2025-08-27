import java.util.ArrayList

// Generic: <T1, T2, ... >

// generic for class:
// class ClassName<T1, T2..., Tn>

// for function
// fun <T1, T2, ... , Tn> functionName()

// ràng buộc T
// <T: Number>  -> T phải là number/subclass của number
// đa ràng buộc:
// thêm: where T: Class1, T: Class2, ....

class Random<T : Number> {
    fun rand(): T {
        val random = Math.random() * (1e5 + 7)
        return random as T
    }
}

// for function
fun <T> printItem(item: T) {
    println(item)
}

// variance: in, out, star (*)
// out -> cho phép đọc an toàn
// gán từ kiểu sub sang super -> cùng trỏ tới 1 địa chỉ và địa chỉ đó
// do không thể ghi nên data luôn là kiểu của Sub nhưng đã được nâng lên thành kiểu Super
// khi này, ta có thể có list các data khác loại (do cùng super nên ta có thể coi như danh sách các
// Super)
// các hàm bên trong không được nhận tham số kiểu T, Chỉ có thể xuất ra T

class Box1<out T>(val value: T) {
    fun get(): T = value // function này trả về T
    // fun process(smth: T) {} // error

    override fun toString() = value.toString()
}

// in -> gán super cho subclass
// -> ghi an toàn vì sub có đầy đủ mọi thứ của super
// tức là các hàm chỉ nhận T vào làm tham số, không được trả về T
class Box2<in T : Number> {
    fun compare(a: T, b: T): Number {
        return a.toDouble().compareTo(b.toDouble())
    }
    // fun returnT(smth: Any): T {} // error -> khong duoc tra ve T
}

fun main() {
    val randInt = Random<Int>()
    for (i in 1..10) print("${randInt.rand()} ")
    println()

    val randDouble = Random<Double>()
    for (i in 1..10) print("${randDouble.rand()} ")
    println()
    printItem(100)
    printItem("HelloWorld!")

    // out, in, star *
    println("\n--------------------")
    // out -> ghi lên
    val b1 = Box1<Number>(30)
    val b1_: Box1<Any> = b1 // ok
    // val b1__ : Box1<Int> = b1 // error
    println(b1.get())
    println(b1_.get())
    // mục đích: lưu trữ các data khác loại trong cùng collection -> listOf
    // ex: Build a list of differenct type object
    val b1a = Box1<Number>(30)
    val b1b = Box1<Float>(28.6f)
    val b1c = Box1<Int>(88)
    val b1d = Box1<String>("HelloWorld")
    val b1e = Box1<ArrayList<Int>>(arrayListOf(9, 9, 9, 9, 9))
    // tất cả đều là <out T> -> có thể cast thành Box1<Any> -> cùng 1 loại -> lưu cùng 1 nơi mà mỗi
    // phần tử dạng Box1<Any>
    val pyList: ArrayList<Box1<Any>> = ArrayList()
    pyList.add(b1a)
    pyList.add(b1b)
    pyList.add(b1c)
    pyList.add(b1d)
    pyList.add(b1e)
    println("PyList: ${pyList}")

    // in: Đọc xuống
    val b2: Box2<Number> = Box2()
    // int compare
    val b2Int: Box2<Int> = b2
    println("${b2.compare(3, 5)} // ${b2Int.compare(3, 5)}") // -> b2Int.compare(3, 5)
    println(b2.compare(9.9, -1.3)) // double
    println(b2.compare(1, 13.3)) // int vs double (Number Number)
    // in: tạo thằng to nhất để xử lý được hết các thằng con

    // * -> khi không biết T là gì, dùng * :)
    // * dưa vào:
    // - Param's Type của constructor -> constructor phải có param
    // - Kiểu chỉ định cụ thê:
    // ex: val example: ClassName<*> = ClassName<Numbber>() -> khi này nó lấy Number làm T
    // * hướng tới đọc là chủ yêu (out T) -> * ~ out Any
    // ex
    // Box1<out T> -> Box1<*> ~ Box1<out Any>
    val b1StarNumber: Box1<*> = Box1(30)
    val b1StarString: Box1<*> = Box1("hello")
    println(b1StarNumber.get())
    println(b1StarString.get())
    // or
    printArray(arrayOf(1, 2, 3, 4, 5))
    printArray(arrayOf("Kotlin", "Generic", "Lol"))

    println("\n--------------------")
    println("#vduczz")
}

fun printArray(arr: Array<*>) {
    for (item in arr) print("$item ")
    println()
}
