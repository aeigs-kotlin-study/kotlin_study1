package taewoo.session3.lec12


object singleton {
    var a = 10
}

fun main() {
    val newBaby = Person.Factory.newBaby("홍길동")
    println(newBaby.name)
    println(newBaby.age)

    println(singleton.a)
    singleton.a = 30
    println(singleton.a)

    moveSomething(object : Movable {
        override fun move() {
            println("터벅 터벅")
        }

        override fun fly() {
            println("파닥 파닥")
        }
    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}