class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        for (i in 1 .. key.size) {
            val unlockPad = createUnlockPad(lock, key.size, lock.size, i)
            for (direction in 0..3) {
                val newKey = createNewKey(key, direction)
                if (isCorrectKey(newKey, unlockPad, lock.size, i)) return true
            }
        }
        return false
    }

    fun isCorrectKey(key: Array<IntArray>, newMatrix: Array<IntArray>, lockSize: Int, offset: Int): Boolean {
        for (y in 0 until newMatrix.size - key.size) {
            for (x in 0 until newMatrix.size - key.size) {
                val result = tryUnlock(key, newMatrix, y, x)
                val croppedLock = Array(lockSize) { y ->
                    IntArray(lockSize) { x ->
                        result[key.size - offset + y][key.size - offset + x]
                    }
                }

                if(croppedLock.any { it.contains(0) }) continue
                else return true
            }
        }
        return false
    }

    fun tryUnlock(key: Array<IntArray>, lock: Array<IntArray>, y: Int, x: Int): Array<IntArray> {
        val unlock = lock.map { it.clone() }.toTypedArray()

        for (ky in key.indices) {
            for (kx in key.indices) {
                unlock[y + ky][x + kx] = key[ky][kx] xor lock[y + ky][x + kx]
            }
        }

        return unlock
    }

    fun createUnlockPad(lock: Array<IntArray>, keySize: Int, lockSize: Int, shift: Int): Array<IntArray> {
        val newMatrixSize = lockSize + (keySize - shift) * 2
        val newMatrixOffset = keySize - shift
        return Array(newMatrixSize) { y ->
            IntArray(newMatrixSize) { x ->
                if (y in newMatrixOffset until newMatrixOffset + lockSize && x in newMatrixOffset until newMatrixOffset + lockSize) {
                    lock[y - newMatrixOffset][x - newMatrixOffset]
                }
                else 0
            } }
    }

    fun createNewKey(key: Array<IntArray>, direction: Int): Array<IntArray> {
        return when (direction) {
            in 1..3 -> {
                var rotatedKey = key.map { it.clone() }.toTypedArray()
                repeat(direction) { rotatedKey = rotate(rotatedKey) }
                rotatedKey
            }
            else -> key
        }
    }

    fun rotate(key: Array<IntArray>): Array<IntArray> {
        return Array(key.size) { y -> IntArray(key.size) { x -> key[key.size - 1 - x][y] } }
    }

}

/* 1
fun main() {
    val array1 = arrayOf(intArrayOf(0,0,0), intArrayOf(1,0,0), intArrayOf(0,1,1))
    val array2 = arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1))
    print(Solution().solution(array1, array2))
}

class Solution {
    fun rotate(key: Array<IntArray>): Array<IntArray> {
        val N = key.size
        val array = Array(N) { IntArray(N) }

        for(i in 0 until N)
            for(j in 0 until N)
                array[j][N - 1 - i] = array[i][j]
        return array
    }
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var answer = true

        val (N, M) = key.size to lock.size
        var temp = key

        for(z in 0 until 4) {
            temp = rotate(temp)
            for(i in 0 until M + N - 1)
                for(j in 0 until M + N - 1) {
                    val array = Array(N - 2 + (2 * M)) { IntArray(N - 2 + (2 * M))}
                    for(a in 0 until N)
                        for(b in 0 until N)
                            array[M - 1 + a][M - 1 + b] = lock[a][b]
                    for(c in 0 until M)
                        for(d in 0 until M)
                            array[i + c][j + d] += temp[c][d]

                    for(n in M - 1 until M + N - 1) {
                        for(m in M - 1 until M + N - 1)
                            if(array[n][m] != 1) {
                                answer = false
                                break
                            }
                        if(answer) break
                        }
                }
        }

        return answer
    }
}
*/

/* 2
class Solution {
    fun rotate(key: Array<IntArray>) {
        for(i in key.indices)
            for(j in key.indices)
                key[i][j] = key[key.size - 1 - j][i]
    }
    fun check(n: Int, lock: Array<IntArray>): Boolean {
        for(i in n until 2 * n)
            for(j in n until 2 * n)
                if(lock[i][j] != 1) return false
        return true
    }
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val answer = false

        val lock3 = Array(lock.size * 3) { IntArray(lock.size * 3) }
        val (n, m) = lock.size to key.size
        for(i in 0 until n)
            for(j in 0 until n)
                lock3[n + i][n + j] = lock[i][j]

        for(r in 0 until 4) {
            rotate(key)
            for(a in n - m + 1 until 2 * n)
                for(b in n - m + 1 until 2 * n) {
                    for (i in 0 until m)
                        for (j in 0 until m)
                            lock3[a + i][b + j] += key[i][j]
                    if(check(n, lock3)) return true
                    for (i in 0 until m)
                        for (j in 0 until m)
                            lock3[a + i][b + j] -= key[i][j]
                }
        }
        return answer
    }
}
*/