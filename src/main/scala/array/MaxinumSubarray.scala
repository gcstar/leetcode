package array

import scala.collection.mutable

/**
  * leetcode 53
  */
object MaxinumSubarray {
  def maxSubArray(nums: Array[Int]): Int = {
    var max = Integer.MIN_VALUE
    var current = 0
    nums.foreach(i => {
      if (current < 0) {
        current = i
      } else {
        current += i
      }
      max = math.max(current, max)
    })
    max
  }

  def main(args: Array[String]): Unit = {
    println(maxSubArray(Array(-2, -1, -3, -4, -1, -1, -2, -5, -4)))
  }
}
