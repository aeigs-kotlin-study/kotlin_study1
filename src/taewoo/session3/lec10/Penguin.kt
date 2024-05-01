package taewoo.session3.lec10

class Penguin(spices: String) : Animal(spices, 2), Flyable, Swimable {

    private val wingCount = 2;

    override fun move() {
        println("펭귄은 뒤뚱뒤뚱 걸어갑니다.")
    }

    override val legCount: Int
        get() = super.legCount + wingCount

    override fun act() {
        super<Flyable>.act()
        super<Swimable>.act()
    }

    override fun fly() {
        println("하늘을 날아요")
    }

}