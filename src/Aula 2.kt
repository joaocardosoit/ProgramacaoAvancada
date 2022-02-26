import java.util.concurrent.atomic.DoubleAccumulator

class `Aula 2` {

}

fun main(args: Array<String>){
    val s = sumRangeRec(1, 5) // 15
    val tail = sumRange(1, 5) // 15

    println(tail)
}

fun sumRangeRec(a: Int, b: Int): Int {
    return if(a == b) {
        a
    } else {
        a + sumRangeRec(a + 1, b)
    }
}

fun sumRange(min: Int, max: Int): Int{
    tailrec fun aux(min: Int, count: Int = 0): Int =
        if (min == max) min
        else aux(min + 1, max)
        return aux(min,max)
}
