package taewoo.sesson1

fun main() {
    val person = Person(null, null)
    println(startsWith(person.name ?: "null"))
}

fun startsWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException()
}

fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun startsWith(str: String): Boolean {
    return str.startsWith("A")
}