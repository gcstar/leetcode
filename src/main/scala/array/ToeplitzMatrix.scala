package array

/**
  * leetcode 766
  */
object ToeplitzMatrix {

  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    val outLength = matrix.length
    val innerLength = matrix(0).length
    for (i <- 0 until outLength) {
      for (j <- 0 until innerLength) {
        val tempA = i - 1
        val tempB = j - 1
        if (tempA >= 0 & tempA < outLength && tempB >= 0 && tempB < innerLength) {
          if (matrix(i)(j) != matrix(tempA)(tempB)) {
            return false
          }
        }
      }
    }
    true
  }

  def main(args: Array[String]) = {
    val matrix = Array(Array(1, 2, 3, 4), Array(5, 1, 2, 3), Array(9, 5, 1, 2))
  }

  }
