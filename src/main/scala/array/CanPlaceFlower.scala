package array

/**
  * leetcode 605
  */
object CanPlaceFlower {
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    var max = 0
    var current = 0
    flowerbed.foreach(i => {
      if (i == 0) {
        current += 1
      } else {
        current = 0
      }
      max = math.max(current, max)
    })
    println(max)
    false

  }

  def main(args: Array[String]): Unit = {
    println(canPlaceFlowers(Array(0, 0, 1, 0, 1), 1))
  }
}
