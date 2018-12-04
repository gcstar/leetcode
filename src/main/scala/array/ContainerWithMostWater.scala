package array

/**
  * by guchao on 2018/12/4.
  * leecode 11
  */
object ContainerWithMostWater {
  def maxArea(height: Array[Int]): Int = {
    var maxArea = 0
    for (i <- 0 until height.length) {
      for (j <- i until height.length) {
        val width = math.min(height(i), height(j))
        val h = j - i
        if (width * h > maxArea) {
          maxArea = width * h
        }
      }
    }
    maxArea
  }
}
