package array

/**
  * @author:Created by guchao on 2018/12/4.
  * leetcode 1
  */
object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var result = Array(0, 0)
    for (i <- 0 until nums.length) {
      for (j <- 0 until nums.length) {
        if (nums(i) + nums(j) == target && i != j) {
          result(0) = i;
          result(1) = j;
        }
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val array = twoSum(Array(1, 2, 3), 3)
    printf(s"num1:${array(0)},num2:${array(1)}")
  }
}
