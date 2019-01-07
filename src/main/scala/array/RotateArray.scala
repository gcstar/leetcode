package array

/**
  * Created by guchao on 18/12/19.
  */
object RotateArray {
  def rotate(nums: Array[Int], k: Int): Unit = {
    if (nums.length == 1) {

    } else {
      var temp = k
      if (k > nums.length) {
        temp = k - nums.length
      }

      var p = nums.length - temp
      var q = 0
      val end = nums.length


      while (p < end) {
        val t = nums(p)
        nums(p) = nums(q)
        nums(q) = t
        p = p + 1
        q = q + 1
      }

      for (i <- nums) {
        print(i + ",")
      }
    }

  }

  def main(args: Array[String]): Unit = {
    rotate(Array(1, 2), 3)
  }

}
