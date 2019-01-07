package array

/**
  * Created by guchao on 18/12/21.
  * leetcode 136
  */
object SingleNumber {
  def singleNumber(nums: Array[Int]): Int = {
    var result = 0
    for(num<-nums){
      result = result ^ num
    }
    result
  }

  def main(args: Array[String]): Unit = {
      println(singleNumber(Array(4,1,2,1,2)))
  }

}
