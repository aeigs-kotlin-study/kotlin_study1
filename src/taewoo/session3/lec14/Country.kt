package taewoo.session3.lec14

enum class Country(
    val code: String
) {
    KOREA("KO"),
    AMERICA("US")

}

fun handleCountry(country: Country): String {
    return when (country) {
        Country.KOREA -> "한국입니다"
        Country.AMERICA -> "미국입니다."
    }
}

fun main() {
    println(handleCountry(Country.KOREA))
}