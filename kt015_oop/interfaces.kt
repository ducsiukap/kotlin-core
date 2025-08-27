// interface: collection of abstract members (fields, methods)

interface Runable1 {
    // abstract fields
    var speed: Int
    // default field (have implemented get()&set(value))

    // abstract method
    fun start()
    fun speedUp(s: Int)
    fun speedDown(s: Int)

    // default method
    fun stop() {
        this.speed = 0
    }
}

class Car1(speed: Int) : Runable1 {
    override var speed = speed

    override fun start() {
        println("Car is running")
        speed = if (speed == 0) 5 else speed
    }

    override fun stop() {
        super.stop()
        println("Car is stopped!")
    }

    override fun speedUp(s: Int) {
        this.speed += s
        println("Speed: +${s}km/h")
    }

    override fun speedDown(s: Int) {
        val slow = Math.min(s, this.speed)
        this.speed -= slow

        println("Speed: -${slow}km/h")
    }
}

// functional interface:
// - only one abstract method

fun interface MyMath {
    fun operate(vararg nums: Int): Int
}

fun main() {
    val car = Car1(0) // stopping

    car.start()
    car.speedUp(30)
    car.speedDown(10)
    car.speedUp(80)
    car.speedDown(50)
    car.stop()
    println(car.speed)

    // functional interface
    println("\n--------------------")
    val add: MyMath = MyMath { nums -> nums.sum() }
    val mul: MyMath = MyMath { nums ->
        var total = 1
        for (num in nums) total *= num
        total
    }

    val intArr = intArrayOf(1, 2, 3, 4, 5)
    println(add.operate(*intArr))
    println(mul.operate(*intArr))

    println("\n--------------------")
    println("#vduczz")
}
