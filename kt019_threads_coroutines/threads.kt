// similar to Java thread

class MyThread(name: String) : Thread(name) {

    override fun run() {
        for (i in 1..5) {
            println("${Thread.currentThread().name} count ${i}")
            Thread.sleep(500)
        }
    }
}

class MyRunnable : Runnable {
    override fun run() {
        for (i in 1..5) {
            println("${Thread.currentThread().name} count ${i}")
            Thread.sleep(500)
        }
    }
}

fun main() {
    // class extends Thread
    val t1 = MyThread("Thread 01")
    val t2 = MyThread("Thread 02")

    // Thread(Runnable)
    val t3 = Thread(MyRunnable(), "Runnable 01")
    val t4 = Thread(MyRunnable(), "Runnable 02")

    // using Thread { //block of codes}
    val t5 = Thread {
        for (i in 1..5) {
            println("${Thread.currentThread().name} count ${i}")
            Thread.sleep(500)
        }
    }
    t5.name = "Thread 03"

    // start
    t1.start()
    t2.start()
    t3.start()
    t4.start()
    t5.start()

    println("\n--------------------")
    println("#vduczz")
}
