package basic

fun main() {

    // 사용자로부터 특정 문자열 들어왔을 때 종료
    var str:String?
    do{
        print("input: ")
        str = readLine()
        println("view : $str")
    }while(str != "exit")
    println("exit")

    // 특정 값을 검색하는 경우, 특정 값 찾았다면 이후 검색 필요 없다.
    first@ for(i in 1..10){
        second@ for(k in 1..10){
            if(i == k) continue@second
            println("$i * $k = ${i * k}")
        }
    }

    /*
    try-catch (예외처리) 문은 꼭 필요한 곳에서만 사용하도록 한다.
    빠른 속도가 필요하다면 예외처리문을 모든 곳에서 사용해선 안된다.
    */

    var a:Int
    var b:Int

    print("A 값 입력: ")
    a = readLine()!!.toInt()
    print("B 값 입력: ")
    b = readLine()!!.toInt()

    try{
        if(b == 0) throw Exception("0으로 나눌 수 없습니다.")
        println("A / B = ${a/b}")
    }catch(e:Exception){
        println("오류 발생: ${e.message}")
    }

    // 람다식의 제약을 무시하고 사용하기위해 익명 함수를 사용.
    // 람다식은 return 키워드 사용하지 않음. 마지막 연산이 반환 결과

    TestLambda { a, b -> a + b }
    TestLambda { a, b ->
        a + b
        a * b
    }

    // 람다식에 매개변수 없을 때 화살표 포함 이전부분 작성하지 않아도된다.
    val printHello:()->Unit = {println("Hello world!")}
    printHello()

    TestFunc({println("lambda Exp 1")}, {println("lambda Exp 2")})

    // 마지막 람다식을 밖으로 뺄 수 있다.
    TestFunc({println("lambda Exp 1")}){
        println("lambda Exp 2")
    }

    // 변수에 할당된 람다식
    val vLamb:()->Unit = {println("Hello world!")}

    TestFunc(vLamb){
        vLamb()
    }
    val vDblLamb:()->()->Unit = {{println("Hello world!")}}
    vDblLamb()()
}

fun TestLambda(lambda:(Int, Int) -> Int){
    println("3 + 5 = ${lambda(3, 5)}")
}
fun TestFunc(lamb1:()->Unit, lamb2:()->Unit){
    lamb1()
    lamb2()
}