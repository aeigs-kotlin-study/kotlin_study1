package taewoo.session3.lec10

class Derived(
    number: Int
) : Base(number) {
    init {
        println("Derived class")
        println(super.number)
    }
}