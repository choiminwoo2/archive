package org.ruu.kt.leetcode.mid


class LongestSubStrWithoutRepeatingChar {

    fun lengthOfLongestSubstring(s: String): Int {

        if(s.isEmpty()) return 0

        var maxLength = 0
        val charIndex = HashMap<Char, Int>()
        var start = 0

        for(end in s.indices) {
            val currentChar = s[end]

            if(charIndex.containsKey(currentChar) && charIndex[currentChar]!! >= start) {
                start = charIndex[currentChar]!! + 1
            }

            charIndex[currentChar] = end

            maxLength = maxOf(maxLength, end - start + 1)
        }

        return maxLength
    }
}