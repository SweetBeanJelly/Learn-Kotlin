package BOJ_2021_03월

fun main() {
    val dx=arrayOf(-2,-2,-1,-1,1,1,2,2)
    val dy= arrayOf(1,-1,2,-2,2,-2,1,-1)

    repeat(readLine()!!.toInt()){
        val n=readLine()!!.toInt()
        val (startX,startY)=readLine()!!.split(' ').map { it.toInt() }
        val (finX,finY)=readLine()!!.split(' ').map { it.toInt() }
        val map=Array(n){IntArray(n)}
        val q: java.util.Queue<Pair<Int,Int>> = java.util.ArrayDeque()
        map[startX][startY]=0
        q.add(Pair(startX,startY))
        while(!q.isEmpty()){
            val (x,y)=q.poll()
            if(x==finX&&y==finY) break
            for(i in 0 until 8){
                if(x+dx[i] in 0 until n && y+dy[i] in 0 until n){
                    if(map[x+dx[i]][y+dy[i]]==0) {
                        map[x + dx[i]][y + dy[i]] = map[x][y] + 1
                        q.add(Pair(x + dx[i], y + dy[i]))
                    }
                }
            }
        }
        println(map[finX][finY])
    }
}