package taewoo.sesson1

fun main() {
    val person = Person("김태우", 100)

//    println("이름: ${person.name}")

    val log: String = """
	ABC
	DEF
	${person.name}
""".trimIndent()

    println(log)
}

fun printAgeIfPerson(obj: Any?) {
//    if (obj is Person) {
//        println(obj.age)
//    }
    val person = obj as? Person
    println(person?.age)
}