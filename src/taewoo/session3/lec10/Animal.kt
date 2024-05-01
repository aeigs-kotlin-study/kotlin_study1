package taewoo.session3.lec10

abstract class Animal(
    protected val species: String,
    protected open val legCount: Int
) {
    abstract fun move();
}