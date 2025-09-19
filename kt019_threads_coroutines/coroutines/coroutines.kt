import kotlinx.coroutines.*

/* Thread và Coroutine
- Thread -> do OS quản lý, JVM map java.lang.Thread with OS Thread
    + Stackful : Mỗi Thread thực sự chiếm vào trăm KB -> vài MB stack memory => system nặng
    + Thread muốn dừng ? -> Thread.sleep -> block luôn cả OS Thread.file
    + Phù hợp tác vụ nặng, số lượng ít.
- Coroutine -> do Kotlin runtime xử lý  (kotlinx.coroutines)
    + là thread ảo -> task nhẹ chạy trong Thread thật
    + Stackless: Coroutine cực nhẹ, không chiếm stack memory => Một JVM Thread có thể chứa hàng ngàn Coroutine.
    + Coroutine muốn dừng -> delay() => nhường thread cho coroutine khác, không block thread.
    + Hỗ trợ bất đồng bộ tốt.
    + Phù hợp xử lý tác vụ nhỏ (IO, Networking)

- Cơ chế nhường thread:
    + Thread: ngẫu nhiên
    + Coroutine: chủ động dừng qua lệnh dừng như delay, và được resume dựa trên thời gian trờ (trạng thái sẵn sàng -> sẵn sàng trước thif chạy trước)
*/

// Coroutine là lightweight alternative cho thread: có thể suspend mà không block thread thật
// có thể suspend (đình chỉ) & ghi nhớ trạng thái
// resume sau đó nhờ trạng thái ghi nhớ mà không chiếm thread.


// Structured concurrency: principle of Coroutines:
//  -> new coroutine can only be launched in a specific CoroutineScope
//  -> mọi coroutine phải cho cha (scope) và phải kết thúc (hoàn tất, bị hủy) khi cha kết thúc
// 3 types of CoroutineScope:
//  - suspend fun coroutineScope
//  - suspend fun supervisorScope
//  - runBlocking -> only for main(), test / entry point
// note:
// - corountineScope và runBlocking sẽ dừng nếu 1 coroutine lỗi (exception)
// - supervisorScope coi con là độc lập, khi 1 coroutine lỗi không ảnh hưởng coroutine khác
// - coroutineScope/supervisorScope chỉ được gọi từ coroutine đang chạy

/* Suspend function ? -> function declared with "suspend" keyword
- ex: suspend fun hello() -> meaning hello() canbe "suspend (or temporary stop)" and not block the thread like Thread.
    -> when hello() is "suspended", it just give the thread to other coroutine, not block the thread.

- Bản chất:
    + suspend function không tự động chạy song song mà cho phép coroutine suspend nó rồi resume.
    + JVM turns suspend functions into state machines

- Suspend function only be invoked within:
    + other suspend function
    + coroutine

- Phù hợp với những công việc nhẹ như IO, network, delay, database…
 */

// runBlocking : only for main() or test
// return suspend fun
fun main() = runBlocking {

    println("\n======================")
    println("Main start")
    println()

    // coroutineScope
    try { // tránh dừng main vì runBlocking cũng dừng nếu có 1 coroutine bị dưnf
        coroutineScope { //
            launch {
                for (i in 1..5) {
                    println("[launch 1] - count: $i")
                    delay(500L)
                }
            }

            launch {
                for (i in 1..5) {
                    println("[launch 2] - count: $i")
                    delay(500L)
                }
            }

            // error coroutine
            launch {
                delay(2000L)
                val e = Exception("Stop exception")
                println("coroutineScope is canceled by Exception $e")
                throw e
            }
        }
    } catch (e: Exception) {
        //
    }


    // supervisorScope
    supervisorScope {
        val job = launch { // return a Job obj
            for (i in 1..5) {
                println("[launch 3] - count: $i")
                delay(500L)
                // yeild() -> nhươn thread cho coroutine khác

            }
        }
        // wait for launch3 complete
        job.join()

        launch {
            for (i in 1..5) {
                println("[launch 4] - count: $i")
                delay(500L)
            }
        }

        // error coroutine
        launch {
            for (i in 1..5) {
                delay(500L)
                val e = Exception("Stop exception")
                println("[launch 5] is canceled by Exception $e")
                throw e
            }
        }
    }

    println("\n======================")
    println("main ends")

    println("\n--------------------")
    println("#vduczz")
}
