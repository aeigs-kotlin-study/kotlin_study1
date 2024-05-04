package taewoo.session3.lec12

class Person (
    var name: String,
    var age: Int
){
    companion object Factory: Log{
        private const val MIN_AGE = 1
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log(str: String) {
            println(str)
        }
    }

}