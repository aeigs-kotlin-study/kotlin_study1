package taewoo.session3.lec14

data class PersonDto(
    val name: String,
    val age: Int = 1
)

fun main() {
    val person1 = PersonDto("김태우", 25)
    val person2 = PersonDto("김태우", 25)

    println(person1 == person2)
    println(person1)

    val person3 = PersonDto("김태우")
    println(person3)

}