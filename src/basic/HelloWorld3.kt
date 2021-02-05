package basic

fun main() {

    // class
    val one = Party("HAPPY", 2020)
    println(one.name)

    one.name = "COVID19"
    println(one.name)

    print(Outer().Inner().hello())

    // abstract
    val p = P()
    p.funO()

    // interface
    val shop = mouse()
    shop.shop()
    shop.print()

    // data class
    val test1 = Test("JinYeonGyeong", 96)
    // toString
    print(test1)

    val test2 = Test("JinYeonGyeong", 96)
    // 코틀린에서는 == 와 equals 가 같다.
    print(test1==test2)
    print(test1.equals(test2))

    val test3 = hashSetOf(Test("TEST", 1))
    // hashCode
    print(test3.contains(Test("TEST", 1)))

    // copy
    val test4 = test1.copy(number = 723)

    val regex = """i am ([\w\s]+) (\d+)""".toRegex()
    val matchResult = regex.find("i am Jin YeonGyeong 25")
    val (name, age) = matchResult!!.destructured

    println("$name , $age")
}

class Party(var name:String, var date:Int)

class Outer {
    val a = 20
    inner class Inner {
        fun hello() = a
    }
}

abstract class O {
    abstract fun funO() // { } 작성 X
}
class P : O() {
    override fun funO() {
        print("ABSTRACT")
    }
}

interface shop {
    // 미구현, 구현 포함 가능
    fun shop() // abstract 키워드 생략 O
    fun print() = println("HELLO")
}
class mouse : shop {
    override fun shop() {
        println("MOUSE PRINT")
    }
}

open class a(val name:String)
class b(name:String):a(name)

data class Test(val name:String, val number:Int)