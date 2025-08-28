import java.io.IOException

// runtime/compile-time)

// type of exception
// 1. built-in exception: includes
//      - CheckedException - compile-time exception -> have to handle to compile
//          => ex; IOException, FileNotFoundException, ...
//      - UncheckedException - runtime exception -> programming error
//          => dont need to handle.
//          => but when it occurs, the program will be terminated if no handle is specified
//          ex: ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, ...
// NOTE: in Kotlin, all exception (includes Checked and Unchecked) is unchecked exception!
// So we are not forced to handle them, but it's recommended to do so.

// 2. user-defined exception
class MyException : Exception {
    constructor(message: String) : super(message)

    // we can create some method to provide additional details.
    fun sayHello(name: String = "World") {
        println("Hello $name!")
    }
}

// 2 ways handle exception
class Handler {

    // using try-catch / try-catch-finally
    fun div1(a: Int, b: Int) {
        try {
            val result = a / b
            println(">>> Result: $result")
        } catch (e: ArithmeticException) {

            // do smth

            // methods to get exception information:
            // e.printStackTrace(): Unit // name + message + location
            // e.message:String -> message
            // e.toString(): String -> name + message
            println(">>> catch: ${e.toString()}")
        } catch (e: IOException) {
            // we can catch multiple exception
            println(">>> catch: ${e.toString()}")
        } catch (e: MyException) {
            // catch user-defined exception
            e.sayHello()
        } catch (e: Exception) { // or catch any exception with e: Exception
            e.printStackTrace()
        } finally {
            // finally block is optional
            // it always executes irrespective of whether an exception is handled or not by the
            // catch block
            println(">>> finally block executed! ")
        }

        // kotlin có:
        // try_catch
        // try_finally
        // try_catch_finally

        // finally thường dùng để dọn dẹp tài nguyên
    }

    // using throws -> sử dụng ngay sau khai báo hàm
    // không handle trực tiếp tại nơi xảy ra
    // gán trách nhiệm xử lý tại nơi method được gọi
    // có thể throws multiple exception
    // nhưng Kotlin không có  checked exception nên không thể throws

    // thay bằng throw :)
    fun div2(a: Int, b: Int) {

        if (b == 0) {
            val ex = ArithmeticException("div by 0!")
            // có thể chỉ ra nơi thực sự gây ra exception
            ex.initCause(MyException("My exception ne ahihi"))
            throw ex
        }
        // có thể tiếp tục handle ngay tại đây bằng cách bọc trong try_catch
        // hoặc không handle, đẩy trách nhiệm lên cấp cao hơn (nơi gọi hàm)
        val result = a / b
        println(">>> Result: $result")
    }
}

fun main() {
    val divider = Handler()
    println("\n--------------------")
    // gọi hàm đã được handle bằng try_catch
    divider.div1(2, 1) // normal case
    divider.div1(2, 0) // exception case

    println("\n--------------------")
    // gọi hàm chưa được handle (throw)
    // nên (KHÔNG PHẢI BẮT BUỘC) handle exception : try_catch / throw lên cấp cao hơn nữa ..
    // nếu không handle, khi xảy ra exception có thể gây crash
    divider.div2(2, 1) // normal case
    // handle with try_catch
    try {
        divider.div2(2, 0) // claim ArithmeticException
    } catch (e: ArithmeticException) {
        println(">>> catch: ${e.toString()} in main()!")
    }
    // chỉ try không catch
    try {
        divider.div2(2, 0) // exception case
    } finally {
        println(">>> Programmming will be terminated after this message!")

        println("\n--------------------")
        println("#vduczz")
    } 

    // khoong bao giờ chạy tới dòng này:
    println("Hello world!")
}
