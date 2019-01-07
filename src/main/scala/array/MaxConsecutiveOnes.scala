package array

/**
  * leetcode 485
  */
object MaxConsecutiveOnes {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    var temp = 0
    var max = temp
    for (i <- nums) {
      if (i == 1) {
        temp = temp + 1

      } else {
        if (temp > max) {
          max = temp
        }
        temp = 0
      }
    }
    if (max > temp) max
    else temp
  }

  def main(args: Array[String]): Unit = {
    println(findMaxConsecutiveOnes(Array(1, 1, 0, 1, 1, 1,1,1,0,0,1,1,1,1)))

  }
}
