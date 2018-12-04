package array

/**
  * by guchao
  * leetcode 26
  */
object RemoveDuplicatesFromSortedArray {
  def removeDuplicates(nums: Array[Int]): Int = {
    nums.sorted.distinct.length
  }
}
