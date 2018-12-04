package array

import common.ListNode

/**
  */
object TwoSums2 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var curL1 = l1
    var curL2 = l2
    var i1, i2, res1, res2 = 0

    while (curL1 != null) {
      res1 += (curL1._x * math.pow(10, i1)).toInt
      curL1 = curL1.next
      i1 += 1
    }
    println(res1)
    while (curL2 != null) {
      res2 += (curL2._x * math.pow(10, i2)).toInt
      curL2 = curL2.next
      i2 += 1
    }
    println(res2)


    val result: Seq[Char] = (res1 + res2).toString.toList.reverse

    var head = new ListNode(result(0).toString.toInt)
    var temp = head
    for (c <- 1 until result.length) {
      val n = new ListNode(result(c).toString.toInt)
      temp.next = n
      temp = temp.next
    }
    head
  }

  def main(args: Array[String]): Unit = {

    var n1 = new ListNode(2)
    var n2 = new ListNode(4)
    var n3 = new ListNode(3)
    var n4 = new ListNode(5)
    var n5 = new ListNode(6)
    var n6 = new ListNode(4)
    n1.next = n2
    n2.next = n3
    n4.next = n5
    n5.next = n6

    var node = addTwoNumbers(n1, n4)
    while(node!=null){
      println(node._x)
      node = node.next
    }


  }


}
