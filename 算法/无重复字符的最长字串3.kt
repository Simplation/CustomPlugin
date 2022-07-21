package com.example.rain_demo.algorithm

import kotlin.math.max

/**
 *@author: Rain
 *@time: 2022/7/19 9:09
 *@version: 1.0
 *@description: 无重复字符的最长字串
 *
 */

fun main() {
    val s = "pwwkew"
    val ans = recursion(s.length, s, -1, 0, mutableSetOf<Char>(), 0)
    println(ans)
}

fun cycle() {
    val s = "abcabcbb"
    val occ = mutableSetOf<Char>()
    val size = s.length
    var rk = -1
    var ans = 0
    repeat(size) { i ->
        if (i != 0) {
            val c = s[i - 1]
            occ.remove(c)
        }
        while (rk + 1 < size && !occ.contains(s[rk + 1])) {
            occ.add(s[rk + 1])
            ++rk
        }
        ans = Math.max(ans, rk - i + 1)
    }
}

fun recursion(size: Int, s: String, rk: Int, index: Int, occ: MutableSet<Char>, ans: Int): Int {
    return if (index < size) {
        if (index != 0) {
            occ.remove(s[index - 1])
        }
        val second = second(rk, size, s, occ)
        recursion(size, s, second, index + 1, occ, Math.max(ans, second - index + 1))
    } else {
        ans
    }
}

fun second(curry: Int, size: Int, s: String, occ: MutableSet<Char>): Int {
    return if (curry + 1 < size && !occ.contains(s[curry + 1])) {
        occ.add(s[curry + 1])
        second(curry + 1, size, s, occ)
    } else {
        curry
    }
}