import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // CoroutineScope: môi trường chứa các coroutine.
    // runBlocking, coroutineScope, supervisorScope đều là CoroutineScope
    // -> sử dụng CoroutineScope để tự định nghĩa scope riêng.

    val scope = CoroutineScope(Dispatchers.Default)
    // context: [Job] + Dispatcher + [CoroutineName] + [CoroutineException Handler]
//    Job: quản lí vòng đời coroutine: cancel, join, trạng thái ...
//    Job() -> độc lập, không bị cancel bới thread cấp trên
//    SupervisorJob()
    // Dispatcher:
//    Dispatchers.Default → thread pool chung (DefaultDispatcher), tối ưu CPU-bound (sort, compute, parse JSON…).
//    Dispatchers.IO → thread pool tối ưu I/O (network, DB, file…).
//    Dispatchers.Main → Main/UI thread (Android, JavaFX…).
//    Dispatchers.Unconfined → bắt đầu ở thread hiện tại, sau suspend có thể resume ở thread khác (ít khi dùng).
    // có thể gán Dispatcher cho launch
    // launch (Dispatcher.type) { // do smth}


    // launch
    scope.launch {
        delay(1000)
        println("task1")
        delay(1000) // this line never be run
        println("task1 will be stop by scope.cancel()")
    }

    scope.launch(Job()) {
        delay(2000)
        println("task2")
        delay(2000)
        print("Job2 is not affected by cancellation of scope.cancel()")
    }

    delay(1200)

    scope.cancel() // dừng scope + coroutine con
    println("scope is canceled!")

    delay(10000) // đợi task1

    // => quản lý các coroutine con
}

// GlobalScope