package array

/**
  * leetcode 941
  */
object ValidMountainArray {
  def validMountainArray(A: Array[Int]): Boolean = {
    if (A == null || A.length < 3) {
      return false
    }
    var max = (0, A(0))
    for (i <- 0 until A.length) {
      if (A(i) >= max._2) {
        max = (i, A(i))
      }
    }


    if (max._1 == A.length - 1 || max._1 == 0) return false

    var before = A.slice(0, max._1 + 1)
    var after = A.slice(max._1, A.length)


    var temp = before(0)
    for (i <- 1 until before.length) {
      if (temp >= before(i)) return false
      else temp = before(i)
    }
    temp = after(0)
    for (i <- 1 until after.length) {
      if (temp <= after(i)) return false
      else temp = after(i)
    }
    true
  }

  def main(args: Array[String]): Unit = {
    var arr = Array(14, 82, 89, 84, 79, 70, 70, 68, 67, 66, 63, 60, 58, 54, 44, 43, 32, 28, 26, 25, 22, 15, 13, 12, 10, 8, 7, 5, 4, 3)
    println(validMountainArray(arr))
  }
}
