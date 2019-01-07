package array

/**
  * leetcode 922
  */
object SortArrayByParityII {

  def sortArrayByParityII(A: Array[Int]): Array[Int] = {
    var i = 0
    var j = 1

    while (i < A.length && j < A.length) {
      while (i < A.length && !isOdd(A(i))) {
        i += 2
      }
      while (j < A.length && isOdd(A(j))) {
        j += 2
      }

      if (i < A.length && j < A.length) {
        val temp = A(i)
        A(i) = A(j)
        A(j) = temp
      }
    }
    A
  }

  def isOdd(num: Int): Boolean = {
    if (num % 2 == 1) {
      true
    } else {
      false
    }
  }

  def main(args: Array[String]): Unit = {

    val a = sortArrayByParityII(Array(2, 3, 1, 1, 4, 0, 0, 4, 3, 3))
    for (i <- a) {
      print(i + ",")
    }

  }

}
