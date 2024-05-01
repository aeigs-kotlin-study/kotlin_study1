package taewoo.mergesort

fun main() {
    val s = listOf(5, 1, 13, 7, 9, 2).toIntArray()

    mergesort(6, s)

    println(s.toList())
}

fun mergesort(n: Int, s: IntArray) {
    val h = n / 2
    val m = n - h

    if (n > 1) {

        val u = s.copyOfRange(0, h)
        val v = s.copyOfRange(h, n)

        mergesort(h, u)
        mergesort(m, v)
        merge(h, m, u, v, s);
    }
}

fun merge(h: Int, m: Int, u: IntArray, v: IntArray, s: IntArray) {

    var i = 0;
    var j = 0;
    var k = 0;

    while (i < h && j < m) {
        if (u[i] < v[j]) {
            s[k] = u[i]
            i++
        } else {
            s[k] = v[j]
            j++
        }
        k++;
    }

    if (i > h)
        while (j < v.size) {
            s[k] = v[j]
            k++
            j++
        }
    else
        while (i < u.size) {
            s[k] = u[i]
            k++
            i++
        }
}
