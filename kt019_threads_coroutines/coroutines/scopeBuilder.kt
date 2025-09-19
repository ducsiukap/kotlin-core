import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

// Scope Builder  : Tạo Coroutine Scope
// runBlocking
// coroutineScope
// supervisorScope


// coroutineScope -> Thread suspend
// suspend hàm đang chạy cho tới khi các coroutine bên trong thực hiện xong
suspend fun test() = coroutineScope {
    launch {
        println("[test] [launch 1] STARTS....")
        for (i in 1..5) {
            println("[test][launch 1] - count $i")
            delay(150)
        }
        println("[test] [launch 1] ENDS....")
    }

    launch {
        println("[test] [launch 2] STARTS....")
        for (i in 1..5) {
            println("[test] [launch 2] - count $i")
            delay(270)
        }
        println("[test] [launch 2] ENDS....")
    }

    launch {
        val exception = Exception("An Exception")
        delay(800)
        println("[test] is canceled by exception: $exception")
        throw exception // when this statement is reached,
        // all coroutine parent (test()) scope is stopped.
    }
}


// runBlocking -> Thread blocking
// chặn OS Thread gọi nó cho tới khi nó thực hiện xong
// chỉ nên dùng cho main(), test, entry point
fun main() = runBlocking {
    println("[main] starts")
    println("\n======================")

    // supervisorScope giống coroutineScope
    // nhưng không cancel cả scope vì 1 coroutine con bị exception
    // các coroutine con là độc lập
    supervisorScope {
        // coroutineScope
//        test() // throw exception
        // nếu gọi trực tiếp suspend fun test
        // -> truyền thẳng exception lên main chứ không truyền vào supervisorScope
        launch {
            test()

        }
        launch {
            for (i in 1..5) {
                println("[supervisor] other work is still processing!")
                delay(300)
            }
        }

    }

    println("\n======================")
    println("[main] end")

    println("\n--------------------")
    println("#vduczz")
}

