package com.example.rain_demo.algorithm

/**
 *@author: Rain
 *@time: 2022/7/14 9:33
 *@version: 1.0
 *@description: 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i])。请返回 nums 的动态和。
 * val nums = intArrayOf(3, 1, 2, 10, 1)
 * val nums = intArrayOf(1,2,3,4)
 */
fun main() {

    val nums = intArrayOf(1, 1, 1, 1, 1)
    var index = 1
    while (index < nums.size) {
        nums[index] += nums[index - 1]
        index++
    }

//    val mapIndexed = nums.mapIndexed { index, i ->
//        i.plus(nums.take(index).sum())
//    }
//    val size = nums.size
//    val newNum = IntArray(size)
//    nums.forEachIndexed { index, i ->
//        newNum[index] = i.plus(nums.take(index).sum())
//    }
//    mapIndexed.toIntArray()
//    sumArr(newNum, nums, size - 1)
    println(nums.toString())

}

/**
 * 递归方案
 */
fun sumArr(newNum: IntArray, nums: IntArray, index: Int): Int {
    if (index == 0) {
        newNum[0] = nums[0]
        return nums[0]
    }
    newNum[index] = nums[index] + sumArr(newNum, nums, index - 1)

    return newNum[index]
}