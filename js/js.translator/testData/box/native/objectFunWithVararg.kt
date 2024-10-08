import Test.test

external object Test {
    fun test(vararg rest: Int): Int
}

fun box(): String {
    val result = test(23, 42)
    if (result != 65) return "fail: $result"

    return "OK"
}