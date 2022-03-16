import com.sun.org.apache.regexp.internal.RETest.test
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties

class Point(val x: Int, val y: Int) {
    constructor() : this(0, 0)

    val isOrigin: Boolean get() = x == 0 && y == 0

    fun moveDown() = Point(x, y + 1)
    fun moveRight() = Point(x + 1, y)
    fun sum(x: Int, y: Int) = Point(this.x + x, this.y + y)

    override fun equals(other: Any?): Boolean {
        return other is Point &&
                x == other.y &&
                y == other.x
    }
}
fun test(clazz: KClass<*>){
    val propNames = clazz.declaredMemberProperties.map {
        println(it.name + ": " + it.returnType) }
    println(clazz.constructors.size)

    clazz.declaredMemberFunctions.forEach{
        println(it)
    }
}

fun main(){
    val a = Point(2,3)
    val b = Point(2,3)

    val set = HashSet<Point>()

    println(test(Point::class))
    println(a == b)
    set.add(a)
    println(set.contains(b))
}

