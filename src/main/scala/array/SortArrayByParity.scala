package array

/**
  * leetcode 905
  */
object SortArrayByParity {
  def sortArrayByParity(A: Array[Int]): Array[Int] = {
    import scala.collection.mutable.ArrayBuffer
    var list = ArrayBuffer.empty[Int]
    val g: Map[Int, Array[(Int, Int)]] = A.map(e => (e % 2, e)).groupBy(_._1)
    val even = g.get(0)
    val odd = g.get(1)
    if (!even.isEmpty) {
      for ((_, i) <- even.get) {
        list += i
      }
    }
    if (!odd.isEmpty) {
      for ((_, j) <- odd.get) {
        list += j
      }
    }

    list.toArray
  }

  def main(args: Array[String]): Unit = {
    val a = sortArrayByParity(Array(1, 2, 3, 4))
    for (i <- a) {
      println(i)
    }
  }
}
