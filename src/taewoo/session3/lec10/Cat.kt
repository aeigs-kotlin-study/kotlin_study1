package taewoo.session3.lec10

class Cat(species: String) : Animal(species, 4) {
    override fun move() {
        println("고양이가 사뿐사뿐 걸어갑니다.")
    }
}