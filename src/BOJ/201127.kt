package BOJ

/*
 1. 아스키 코드
 2. 숫자의 합
 3. 알파벳 찾기
 4. 문자열 반복
 5. 단어 공부
*/

/*
fun main() = with(Scanner(System.`in`)) {
    // 1
    /*
    var i = next()[0].toInt()
    print(i)
    */
    // 2
    /*
    var i = nextInt()
    var j: String = next()
    close()
    var sum = 0

    for(k in 0 until i) {
        sum += j[k] - '0'
    }

    print(sum)
    */
    // 4
    /*
    var token = nextInt()
    for(i in 0 until token) {
        var r = nextInt()
        var str = next()

        for(j in str.indices) {
            for(k in 0 until r) {
                print(str[j])
            }
        }

        println()
    }
    */
}
*/

fun main() {
    // 3
    /*
    var array = IntArray(26)

    for(i in array.indices) {
        array[i] = -1
    }

    val str = readLine()

    if (str != null) {
        for(i in str.indices) {
            var c = str[i]

            if(array[c - 'a'] == -1) {
                array[c - 'a'] = i
            }
        }
    }

    for(j in array) {
        print("$j ")
    }
    */
    // 4
    /*
    var array = IntArray(26)
    var str = readLine()!!

    for(i in str.indices) {
        if(str[i] in 'a'..'z') {
            array[(str[i]-97).toInt()]++
        } else {
            array[(str[i]-65).toInt()]++
        }
    }

    var max = -1
    var c = '?'

    for(j in 0 until 26) {
        if(array[j] > max) {
            max = array[j]
            c = (j+65).toChar()
        } else if (array[j] == max) {
            c = '?'
        }
    }
    print(c)
    */
}