package org.ruu.kt.leetcode.ez

class TwoSum {
    fun twoSum(nums: IntArray, target: Int) : IntArray {

        val tracker = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if(tracker.containsKey(nums[i])) {
                val left : Int = tracker[nums[i]]!!
                return intArrayOf(left, i)
            }else {
                tracker.put(target - nums[i], i)
            }
        }
        return intArrayOf()
    }
}