package com.example.rain_demo.algorithm

/**
 *@author: Rain
 *@time: 2022/7/15 10:53
 *@version: 1.0
 *@description: 描述
 */
fun main() {
    val listNode = ListNode(2)
    val listNode1 = ListNode(4)
    listNode.next = listNode1
    listNode1.next = ListNode(3)

    val listNode2 = ListNode(5)
    val listNode3 = ListNode(6)
    listNode2.next = listNode3
    listNode3.next = ListNode(4)

    val numbers = addTwoNumbers(listNode, listNode2)
    println(numbers.toString())
}


fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    return recursion(l1, l2, null, null, 0)
}

/**
 * @param carry 末位余数
 */
fun recursion(
    l1: ListNode?,
    l2: ListNode?,
    head: ListNode?,
    tail: ListNode?,
    carry: Int,
): ListNode? {
    var c1 = carry
    var h1 = head
    var t1 = tail
    if (l1 != null || l2 != null) {
        val n1 = l1?.`val` ?: 0 //获取第一位
        val n2 = l2?.`val` ?: 0
        val sum = n1 + n2 + c1
        if (h1 == null) {
            t1 = ListNode(sum % 10) // 计算是否进一位
            h1 = t1
        } else {
            t1?.next = ListNode(sum % 10)
            t1 = t1?.next
        }
        c1 = sum / 10
        return recursion(l1?.next, l2?.next, h1, t1, c1)
    } else {
        if (carry > 0) {
            t1?.next = ListNode(carry)
        }
        return h1
    }
}

/**
 * 循环
 */
fun list(l11: ListNode?, l22: ListNode?) {
    var l1 = l11
    var l2 = l22
    var head: ListNode? = null
    var tail: ListNode? = null
    var carry = 0
    while (l1 != null || l2 != null) {
        val n1 = l1?.`val` ?: 0
        val n2 = l2?.`val` ?: 0
        val sum = n1 + n2 + carry
        if (head == null) {
            tail = ListNode(sum % 10)
            head = tail
        } else {
            tail?.next = ListNode(sum % 10)
            tail = tail?.next
        }
        carry = sum / 10
        if (l1 != null) {
            l1 = l1.next
        }
        if (l2 != null) {
            l2 = l2.next
        }
    }
    if (carry > 0) {
        tail?.next = ListNode(carry)
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "ListNode(`val`=$`val`, next=$next)"
    }
}