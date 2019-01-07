package array

/**
  * Created by guchao on 18/12/21.
  * leetcode 167
  */
object TwoSumIIInputArrayIsSorted {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    var i = 0
    var j = numbers.length - 1

    while (i < j) {
      if (numbers(i) + numbers(j) > target) {
        j -= 1
      }
      else if (numbers(i) + numbers(j) < target) {
        i += 1
      } else {
        return Array(i + 1, j + 1)
      }

    }
    return Array(-1, -1)

  }

  def main(args: Array[String]): Unit = {

    val arr = twoSum(Array(2, 7, 11, 15), 19)
    for (num <- arr) {
      print(num + ",")
    }

  }

}
