fun main() {
    // Break - break the loop (exit loop)
    println("\n--------------------")
    println("Unlabeled break")
    // unlabeled break - exit the closest loop that includes it
    for (i in 1..5) {
        print("Outer: ")
        for (j in 1..5) {
            print("Inner$i ")
            if (j == i) {
                print("--- return to outer loop ---")
                break
            }
            // break the inner loop if i == j
            // the outer loop is till running
        }
        println()
    }
    println("--------------------")
    println("Labeled break")
    // labeled loop - exit any relative loop when meet condition
    // assign label to loop: label@ while/for/do-while
    // break@label
    var i: Int = 1
    var destination: Int = 25
    while_loop@ while ((i * i).compareTo(destination) < 0) {
        print("while_loop@ #i=$i: ")
        var j: Int = 1
        while (true) {
            print("$j ")
            if ((j * j + i * i).equals(destination)) {
                print("#### break while_loop@, i = $i, j = $j")
                // labeled break
                break@while_loop
            }
            if (j * j >= destination) {
                print("--- break inner loop --- ")
                // unlabeled break
                break
            }
            ++j
        }
        println()
        ++i
    }

    // Continue - skip current step in loop
    // unlabeled continue: continue
    // labeled continue: continue@label
    // similar with break

    println("\n--------------------")
    println("#vduczz")
}
