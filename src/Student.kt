import kotlin.reflect.KClass
import kotlin.reflect.KClassifier
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.valueParameters

data class Student(val number: Int,
                   val name: String,
                   val type: StudentType? = null) {
}

enum class StudentType{
    Bachelor, Master, Doctoral
}

fun createTable(clazz: KClass<*>): String{
    var string = "CREATE TABLE " + clazz.simpleName + " (" +
    clazz.declaredMemberProperties.joinToString {
        it.name + " " + mapType(it.returnType.classifier)
    }
    return "$string)"
}

fun mapType(classifier: KClassifier?) =
    when(classifier) {
        String::class -> "VARCHAR(255) NOT NULL"
        Int::class -> "INT NOT NULL"
        StudentType::class -> "VARCHAR(8)"
        else -> "NOTFOUND"
}

fun insertInto(clazz: Student): String{
    var string = "INSERT INTO " + clazz::class.simpleName + " (" +
    clazz::class.declaredMemberProperties.joinToString{
        it.name + " VALUES " + it.call(clazz)
    }
    return "$string)"
}
fun main(){
    val clazz = Student::class
    val sql: String = createTable(clazz)
    val s = Student(7, "Cristiano", StudentType.Doctoral)
    val sqlInsert: String = insertInto(s)
    println(sqlInsert)
}