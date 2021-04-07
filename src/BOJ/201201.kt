package BOJ

/*
 1. 손익분기점
 2. 설탕 배달
 3. 벌집 (등차수열)
 4. 분수 찾기
*/

/*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 1
    var str = StringTokenizer(readLine())

    var i = str.nextToken().toInt()
    var j = str.nextToken().toInt()
    var k = str.nextToken().toInt()

    if(k <= j) {
        print("-1")
    } else {
        print(( i / ( k - j )) + 1)
    }
}
*/

fun main() {
    // 2
    /*
    var i = readLine()!!.toInt()
    var count= 0

    while(true) {
        if(i % 5 == 0) {
            print(i / 5 + count)
            break
        }
        else if( i <= 0) {
            print(-1)
            break
        }
        i -= 3
        count++
    }
    */
    // 3
    /*
    var i = readLine()!!.toInt()
    var scope = 1
    var diff = 6
    var room = 1

    while(i > scope) {
        scope += diff
        diff += 6
        room++
    }

    print(room)
    */
    // 4
    /*
    var i = readLine()!!.toInt()
    var count = 1
    var pre = 0

    while(true) {
        if(i <= pre + count) {
            if(count % 2 == 1) {
                print(
                        "${(count - (i - pre -1))}/${(i - pre)}"
                )
                break
            } else {
                print(
                        "${(i - pre)}/${(count - (i - pre - 1))}"
                )
                break
            }
        } else {
            pre += count
            count++
        }
    }
    */
}