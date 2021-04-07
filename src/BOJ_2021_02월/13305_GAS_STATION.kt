package BOJ_2021_02월

/*
 각 도시의 주유소 기름 가격, 각 도시를 연결하는 도로의 길이를 입력받아
 왼쪽 도시에서 오른쪽 도시로 이동하는 최소의 비용 계산
*/

fun main() {
    val city = readLine()!!.toInt()
    val road = readLine()!!.split(" ").map{ it.toLong() }.toLongArray()
    val price = readLine()!!.split(" ").map{ it.toLong() }.toLongArray()

    var result: Long = 0
    var minPrice = price[0]
    for(i in 0 until city - 1) {
        if (price[i] < minPrice) minPrice = price[i]
        result += (minPrice * road[i])
    }
    print(result)
}