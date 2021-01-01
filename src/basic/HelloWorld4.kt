package basic

lateinit var lateString: String // 함수 밖 선언

fun main() {

    // safe call (Null)
    val chr : String? = null

    val call = chr?.length
    print(call)

    val elvis = chr?.length ?: "hello"
    print(elvis)

    val str = "HELLO, WORLD!"
    val safeString: String? = str as? String

    val nullList : List<Int?> = listOf(7, 5, 6, null, 1, null, 9, 6)
    val intList : List<Int> = nullList.filterNotNull()

    print(intList)

    // lateinit, lazy
    lateString = "피망"
    if (::lateString.isInitialized) println("초기화 OK")
    else println("초기화 NO")

    val lazyString : String by lazy {
        val one = 1
        println(one)

        "TEST"
    }

    println(lazyString)
    println(lazyString)

    // replace
    val reg1 = """ab""".toRegex()
    val result1:String = reg1.replaceFirst("ab abc abcd abcde", ":")
    val result2:String = reg1.replace("ab abc abcd abcde",":")

    println(result1)
    println(result2)

    val result3:String = reg1.replace("ab abc abcd abcde abcdef") {
        it.value.toUpperCase() + "#"
    }

    println(result3)

    val reg2 = """\W+""".toRegex()
    val list:List<String> = reg2.split("pinn and jake adventure time",3)

    print(list)

}