// rules:
// - The primary constructor must have at least one parameter.
// - All primary constructor parameters must be marked with val or var.
// - A data class cannot be abstract, open, sealed, or inner.
// - A data class can only implement interfaces, not extend other classes.
data class DataClass(var attr: Int) {

    // Data class provide some method:
    // equals():
    // fun equals(other: DataClass): Boolean {
    //     return this.attr == other.attr
    // }

    // hashCode()
    // toString()
    // copy()
}

// Sealed class => lớp cha có giới hạn số lượng lớp con
// - abstract class đặc biệt
// - tất cả subclass phải khai báo trong cùng 1 file
// - tương thích mạnh với when
// dùng để biểu diễn trạng thái, kết quả, hoặc mấy case rõ ràngX
sealed class FetchState {
    class Error(val msg: String) : FetchState()

    class Success(val data: Int) : FetchState()
}
// subclass bên ngoaif
class Loading : FetchState()
// tương thích tốt với when do tất cả lớp con đã xuất hiện
fun fetchHandling(state: FetchState) {
    when (state) {
        is FetchState.Error -> println("Error: ${state.msg}")
        is FetchState.Success -> println("Data: ${state.data}")
        is Loading -> println("Loading...")
    }
}

// Enum classes
// ~ Tập giá trị mà ta định nghĩa
//  mỗi giá trị như 1 dt
// có thể là: enum class A { Enum1, Enum2, ...}
// or
enum class Month1(val days: Int) {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31)
}

fun main() {
    println("\n---------------Data Class---------------")
    val d1 = DataClass(20)
    println(d1) // d1.toString()

    val d2 = DataClass(30)
    val d3 = DataClass(20)
    println(d1.equals(d2))
    println(d1.equals(d3))
    println()

    val d4 = d1.copy()
    val d5 = d1
    println(d4 == d1) // true
    println(d4 === d1) // false
    println(d5 == d1) // true
    println(d5 === d1) // true

    println("\n---------------Sealed Class---------------")
    fetchHandling(FetchState.Error("Connection Error"))
    fetchHandling(FetchState.Success(100))
    fetchHandling(Loading())

    println("\n---------------Enum class---------------")
    val x = Month1.AUGUST
    println(x) // AUGUST
    println(x.name) // "AUGUST"
    println(x.ordinal) // 8 - thứ tự khai báo
    println(x.days) // biến constructor
    // dùng với when phải cover hết tất cả case của enum
    // values() -> return list of all constant
    for (m in Month1.values()) print(m.name + " ")
    println()
    // valueOf
    println(Month1.valueOf("AUGUST"))
    // read more: https://www.geeksforgeeks.org/kotlin/enum-classes-in-kotlin/

    

    println("\n--------------------")
    println("#vduczz")
}
