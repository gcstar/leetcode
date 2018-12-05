package array

/**
  * leetcode 561
  */
object ArrayPartitionI {
  def arrayPairSum(nums: Array[Int]): Int = {
    val arr = nums.sorted
    var res = 0
    for (i <- 0 until arr.length by 2) {
      res += arr(i)
    }
    res
  }


  def main(args: Array[String]): Unit = {
    val arr = Array(1, 4, 3, 2, 6, 5, 1, 1)
    println(arrayPairSum(arr))
  }
}
