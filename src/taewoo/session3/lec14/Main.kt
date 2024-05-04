package taewoo.session3.lec14

import taewoo.session3.lec14.sealed.Avante
import taewoo.session3.lec14.sealed.HyundaiCar
import taewoo.session3.lec14.sealed.handleHyundaiCar

fun main() {
    println(handleHyundaiCar(Avante()))

}

// 다른패키지이므로 하위 클래스 구현 불가능
//class Kona : HyundaiCar("kona", 4_000L)