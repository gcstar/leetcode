package array

/**
  * Created by guchao on 18/12/19.
  */
object MissingNumber {

  def missingNumber(nums: Array[Int]): Int = {
    var sumValue = 0
    for (i <- 0 until nums.length) {
      sumValue = sumValue + nums(i)
    }
    val sumKey = (0 + nums.length) * (nums.length + 1) / 2
    sumKey - sumValue
  }


  def main(args: Array[String]): Unit = {
    print(missingNumber(Array(3, 0, 1)))
  }

}
