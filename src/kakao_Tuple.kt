// 메소드 체이닝 , 중복되는 원소없는 튜플
// 특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.

class Tuple {
    fun solution (s:String): IntArray {
        return Regex("[0-9,]+").findAll(s)
                .map {it.value}
                .filter {it != ","}
                .toList()
                .map {it.split(",").map {num->num.toInt()}}
                .sortedBy { it.size }
                .fold(setOf<Int>()) {set, list->set.union(list)}
                .toIntArray()
    }
}