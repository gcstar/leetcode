package array
object ThreeSum {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val length = nums.length
    import java.util
    import scala.collection.JavaConverters
    var result = new util.ArrayList[List[Int]]()
    for (i <- 0 until length) {
      for (j <- (i + 1) until length) {
        for (k <- (j + 1) until length) {
          if (nums(i) + nums(j) + nums(k) == 0) {
            result.add(List(nums(i), nums(j), nums(k)))
          }
        }
      }
    }
    JavaConverters.asScalaIteratorConverter(result.iterator()).asScala.toList.map(e => {
      e.sorted
    }).distinct
  }
}
