package array

/**
  * leetcode 888
  */
object FairCandySwap {
  //todo
  def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
    val res = Array(0,0)
    val sumA = A.reduce(_ + _)
    val sumB = B.reduce(_ + _)
    val num = (sumA + sumB) / 2
    var gap = 0
    if (num > sumA) {
      gap = num - sumA

    }


    Array(0)
  }

  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 5)
    val b = Array(2, 4)
    fairCandySwap(a, b)
  }
}
