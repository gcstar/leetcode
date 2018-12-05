package array

/**
  * leetcode 867
  */
object TrasponseMatrix {
  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = {
    val lenA = A.length
    val lenB = A(0).length
    val res = Array.ofDim[Int](lenB, lenA)
    for (i <- 0 until lenA) {
      for (j <- 0 until lenB) {
        res(j)(i) = A(i)(j)
      }
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9), Array(10, 11, 12))

    transpose(arr)
  }
}
