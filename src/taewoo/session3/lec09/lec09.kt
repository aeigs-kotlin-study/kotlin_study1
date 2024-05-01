package taewoo.session3.lec09

class Person(
    val name: String = "홍길동",
    age: Int = 3
) {
    var age = age
        private set

    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }

        println("기본생성자")
    }

    constructor(name: String) : this(name, 1) {
        println("첫번째 생성자")
    }

    constructor() : this("김태우") {
        println("두번째 생성자")
    }

    fun updateAge(age: Int) {
        this.age = age
    }
}


fun main() {
    val p = Person()

    p.updateAge(3)
}