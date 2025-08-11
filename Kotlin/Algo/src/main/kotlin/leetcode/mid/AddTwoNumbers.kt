package org.ruu.kt.leetcode.mid

/**
 * leetcode
 * 2. Add Two Number
 *
 */

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        val dummy = ListNode(0)
        var temp = dummy
        var carry = 0 // 자릿수 올림

        var l1CurrentNode = l1
        var l2CurrentNode = l2

        if(l1CurrentNode != null || l2CurrentNode != null || carry != 0) {
            val val1 = l1CurrentNode?.`val` ?: 0
            val val2 = l2CurrentNode?.`val` ?: 0

            val sum = val1 + val2 + carry;

            carry = sum / 10

            temp.next = ListNode(sum % 10)
            temp = temp.next!! // Null safety

            l1CurrentNode = l1CurrentNode?.next
            l2CurrentNode = l2CurrentNode?.next
        }



        return dummy.next
    }
}

class ListNode(var `val`: Int) {
         var next: ListNode? = null
}