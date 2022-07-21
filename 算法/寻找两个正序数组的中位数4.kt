package com.example.rain_demo.algorithm

/**
 *@author: Rain
 *@time: 2022/7/20 14:34
 *@version: 1.0
 *@description: 寻找两个正序数组的中位数
 */

fun main() {
    val nums1 = intArrayOf(1, 3)
    val nums2 = intArrayOf(2)

    val size1 = nums1.size
    val size2 = nums2.size
    val size = size1 + size2
    if (size % 2 == 0) {
        val midIndex1 = size / 2 - 1
        val midIndex2 = size / 2
        val d = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1,
            nums2,
            midIndex2 + 1)) / 2.0
        println(d)
    } else {
        val midIndex = size / 2
        val kthElement = getKthElement(nums1, nums2, midIndex + 1).toDouble()
        println(kthElement)
    }

}

fun getKthElement(nums1: IntArray, nums2: IntArray, k: Int): Int {
    val size1 = nums1.size
    val size2 = nums2.size
    var index1 = 0
    var index2 = 0
    var ele = k

    while (true) {
        if (index1 == size1) {
            return nums2[index2 + ele - 1]
        }
        if (index2 == size2) {
            return nums1[index1 + ele - 1]
        }
        if (ele == 1) {
            return Math.min(nums1[index1], nums2[index2])
        }
        val h = ele / 2
        val newIndex1 = Math.min(index1 + h, size1) - 1
        val newIndex2 = Math.min(index2 + h, size2) - 1
        val p1 = nums1[newIndex1]
        val p2 = nums2[newIndex2]
        if (p1 <= p2) {
            ele -= (newIndex1 - index1 + 1)
            index1 = newIndex1 + 1
        } else {
            ele -= (newIndex2 - index2 + 1)
            index2 = newIndex2 + 1
        }
    }
}

//region 调用 list api
fun findMedianSortedArrays() {
    val nums1 = intArrayOf(1, 2)
    val nums2 = intArrayOf(3, 4)

    val newNum = DoubleArray(nums1.size + nums2.size)
    val index = add(newNum, nums1, 0)
    val size = second(newNum, nums2, 0, index)
    newNum.sort()
    if (size % 2 == 0) {
        val i = size / 2
        val i1 = i - 1
        val i2: Double = ((newNum[i] + newNum[i1]) / 2)
        println(i2)
    } else {
        val i = (size - 1) / 2
        val i1 = newNum[i]
        println(i1)
    }
}

fun add(newNum: DoubleArray, l: IntArray, index: Int): Int {
    return if (index < l.size) {
        newNum[index] = l[index].toDouble()
        add(newNum, l, index + 1)
    } else {
        index
    }
}

fun second(newNum: DoubleArray, l: IntArray, index: Int, newIndex: Int): Int {
    return if (index < l.size) {
        newNum[newIndex] = l[index].toDouble()
        second(newNum, l, index + 1, newIndex + 1)
    } else {
        newIndex
    }
}
//endregion