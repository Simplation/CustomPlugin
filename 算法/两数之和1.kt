package com.example.rain_demo.algorithm

/**
 *@author: Rain
 *@time: 2022/7/14 9:40
 *@version: 1.0
 *@description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */

/**
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 */
fun main() {
//    val time1 = System.currentTimeMillis()
    val newInt = IntArray(2)
//    sum(newInt, intArrayOf(3, 2, 3), 0, 6)
//    println(System.currentTimeMillis() - time1)
//    println(newInt.toString())
    val nums = intArrayOf(3, 2, 3)
    val target = 6
//    val size = nums.size
//    repeat(size) { index0 ->
//        var index = index0 + 1
//        while (index < size) {
//            if (nums[index0] + nums[index] == target) {
//                newInt[0] = index0
//                newInt[1] = index
//                return
//            }
//            index++
//        }
//    }

    val map = mutableMapOf<Int, Int>()
    var index = 0
    while (index < nums.size) {
        if (map.containsKey(target - nums[index])) {
            val intArrayOf = intArrayOf(map[target - nums[index]]!!, index)
            println(intArrayOf[0])
            println(intArrayOf[1])
        }
        map[nums[index]] = index
        index++
    }
//    nums.forEachIndexed { index, i ->
//        if (map.containsKey(target - i)) {
//            val intArrayOf = intArrayOf(map[target - i]!!, index)
//        }
//        map[i] = index
//    }
}

fun sum(newInt: IntArray, nums: IntArray, index: Int, target: Int) {

    val size = nums.size
    if (index == size - 1) {
        return
    }
    var newIndex = index + 1
//    floor(newInt, nums, index, target, size, newIndex)
    while (newIndex < size) {
        val i = nums[index] + nums[newIndex]
        if (i == target) {
            newInt[0] = index
            newInt[1] = newIndex
            return
        }
        newIndex++
    }
    if (newInt[1] == 0) {
        sum(newInt, nums, index + 1, target)
    }

}

/**
 * 二层递归
 * @param newIndex 后一个index
 */
fun floor(newInt: IntArray, nums: IntArray, index: Int, target: Int, size: Int, newIndex: Int) {
    if (newIndex == size) {
        return
    }
    val i = nums[index] + nums[newIndex]
    if (i == target) {
        newInt[0] = index
        newInt[1] = newIndex
        return
    } else {
        floor(newInt, nums, index, target, size, newIndex + 1)
    }
}


