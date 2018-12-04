package array

/**
  * leecode 896
  */
object MonotonicArray {
  def isMonotonic(A: Array[Int]): Boolean = {

    var flag = true //默认升序
    if (A.length == 1 || A.distinct.length == 1) return true
    val a = A.distinct

    if (a(0) > a(1)) {
      flag = false
    }

    if (flag) {
      for (i <- 0 until A.length - 1) {
        val j = i + 1
        if (A(i) > A(j)) {
          return false
        }
      }
    } else {
      for (i <- 0 until A.length - 1) {
        val j = i + 1
        if (A(i) < A(j)) {
          return false
        }
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    println(isMonotonic(Array(55, 55, 33, 22, 55)))
    println(isMonotonic(Array(2, 2, 2, 2, 2)))

  }
}
