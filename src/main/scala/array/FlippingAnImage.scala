package array

/**
  * leetcode 832
  */
object FlippingAnImage {
  def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {
    val arr = Array.ofDim[Int](A.length, A(0).length)

    for (i <- 0 until A.length) {
      for (j <- 0 until A(0).length) {
        arr(i)(j) = change(A(i)(j))
      }
      arr(i) = arr(i).reverse
    }
    arr
  }

  def change(v: Int): Int = {
    if (v == 0) 1
    else 0
  }


  def main(args: Array[String]): Unit = {

    val arr = Array(Array(1, 1, 0), Array(1, 0, 1), Array(0, 0, 0))
    flipAndInvertImage(arr)


  }

}

