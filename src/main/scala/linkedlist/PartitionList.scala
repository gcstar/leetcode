package linkedlist

import common.ListNode

/**
  * leetcode 86
  */
object PartitionList {
  def main(args: Array[String]) = {

  }

  def partition(head: ListNode, x: Int): ListNode = {
    if (head == Nil) return null
    var temp = head
    var smaller, greater = new ListNode(0)
    var p = smaller
    var q = greater
    while (temp != null) {
      if (temp.x >= x) {
        q.next = temp
        q = q.next
      } else {
        p.next = temp
        p = p.next
      }
      temp = temp.next
    }

    p.next = greater.next
    q.next = null
    return smaller.next


  }

}
