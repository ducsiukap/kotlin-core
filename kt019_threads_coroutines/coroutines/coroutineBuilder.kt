import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.produce

suspend fun fetchData(): Int {
    println("fetching....")
    delay(2000) // 2s
    println("fetch successfully!")
    return Math.random().toInt()
}

fun main() = runBlocking {

    println("[main] starts")
    println("\n======================")

    coroutineScope {
        // launch: tạo coroutine con, return Job (để cancel, join, ...)
        // dùng khi công việc chỉ cần chạy, side-effect, không quan tâm return value
        //
        launch {
            val data = fetchData()
            println("[Data]: $data")
        }
        // other work
        for (i in 1..5) {
            println("processing other work (other thread is running)!")
            delay(700)
        }
    }

    println("\n--------------------\n")

    coroutineScope {
        // async: tạo coroutine con và trả về Deferred<T>
        // khi công việc cần return value, chạy song song nhiều async

        val fetch = async {
            // start : cách coroutine bắt đầu chạy
            //  - CoroutineStart.DEFAULT -> run immediately (default)
            //  - CoroutineStart.LAZY -> run when call .await() or .start()
            //  - CoroutineStart.ATOMIC -> similar to DEFAULT but can not be canceled when it's running.
            //  - CoroutineStart.UNDISPATCHED

            fetchData()
        }


        launch {
            for (i in 1..5) {
                println("processing other work (other thread is running)!")
                delay(700L)
            }
        }


        val data = fetch.await() // lấy data
        // chưa fetch xong
        // -> dừng coroutine mà đang gọi await và các coroutines sử dụng data

        launch { // thread này dùng data -> chờ await() xong
//            println("Processing data...")
            for (i in 1..5) {
                println("processing data: $data")
                delay(500L)
            }
        }
    }

    // produce{} -> ReceiveChannel<T>
    // tạo stream do producer cung cấp để các consumer có thể đọc
    //  => tạo kênh để minh gửi dữ liệu đi
    // gửi vào kênh qua send(data), các consumer đọc từ kênh
    // actor{} -> SendChannel<T>
    // => tạo kênh để người khác gửi tới qua chanel.send(data)
    coroutineScope {

        // produce
        // tạo stream gửi data
        val produceStream: ReceiveChannel<String> = produce {
            var i = 1
            while (true) {
                send("Message #$i")
                delay(500L)

                ++i
            }
        }

        // actor
        // tạo stream nhận data
        val consumer1: SendChannel<String> = actor {
            for (msg in channel) { // channel : luồng dữ liệu vào
                println("[Consumer 1] Received: $msg")
                delay(1000L)
            }
        }
        val consumer2: SendChannel<String> = actor {
            for (msg in channel) { // channel : luồng dữ liệu vào
                println("[Consumer 2] Received: $msg")
                delay(700L)
            }
        }

        // các thread có thể đọc dữ liệu từ kênh
        for (message in produceStream) {
            println("Received: $message")

            // hoặc gửi tới từng actor
            consumer1.send(message)
            consumer2.send(message)

            // sau khi xử lý, message không còn trong produce và không thể đọc lại
        }
        // for (message in produceStream) { //do smth } -> treo

    }
    println("\n======================")
    println("[main] ends")

    println("\n--------------------")
    println("#vduczz")

}