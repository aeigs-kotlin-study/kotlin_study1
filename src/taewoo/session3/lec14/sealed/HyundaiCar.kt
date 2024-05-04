package taewoo.session3.lec14.sealed

sealed class HyundaiCar(
    val name: String,
    val price: Long
)

fun handleHyundaiCar(hyundaiCar: HyundaiCar): String {
    return when (hyundaiCar) {
        is Avante -> hyundaiCar.name
        is Grandeur -> hyundaiCar.name
        is Sonata -> hyundaiCar.name
    }
}