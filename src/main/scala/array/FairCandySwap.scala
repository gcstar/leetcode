package array

/**
  * leetcode 888
  */
object FairCandySwap {
  def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
    val res = Array(0, 0)
    val sumA = A.reduce(_ + _)
    val sumB = B.reduce(_ + _)
    val num = (sumA + sumB) / 2
    var gap = 0
    if (num > sumA) {
      gap = num - sumA
      for (i <- A) {
        for (j <- B) {
          if (i + gap == j) {
            res(0) = i
            res(1) = j
          }
        }
      }
    } else {
      gap = num - sumB
      for (i <- B) {
        for (j <- A) {
          if (i + gap == j) {
            res(0) = j
            res(1) = i
          }
        }
      }
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val a = Array(1, 2,5)
    val b = Array(2, 4)
    val res = fairCandySwap(a, b)
    for(i<-res){
      println(i)
    }
  }
}
