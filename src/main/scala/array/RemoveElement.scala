package array

object RemoveElement {
  def removeElement(nums: Array[Int], tt: Int): Int = {
    var removed = 0
    for (i <- 0 until nums.length) {
      if (nums(i) == tt) {
        removed += 1
      } else {
        nums(i - removed) = nums(i)
      }
    }
    nums.length - removed
  }

}
