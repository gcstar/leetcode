package array

/**
  * leecode 34
  */
object FindFirstAndLastPositionOfElementInSortedArray {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val sorted = nums.sorted
    var min, max = -1
    var first = true
    for (i <- 0 until sorted.length) {
      if (sorted(i) == target) {
        if (first) {
          min = i
          max = i
          first = false
        } else {
          max = i
        }
      }
    }
    Array(min, max)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(5, 7, 7, 8, 8, 10)
    val target = 8

    val res = searchRange(array, target)
    for (i <- res) {
      println(i)
    }

  }
}
