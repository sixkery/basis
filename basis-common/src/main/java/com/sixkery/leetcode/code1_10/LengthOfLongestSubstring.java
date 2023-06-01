package com.sixkery.leetcode.code1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串 中等
 *
 * @author sixkery
 * @since 2023/5/31
 */
public class LengthOfLongestSubstring {

    /**
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，
     * 并更新 start，此时 [start, end] 区间内不存在重复字符
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end, max = 0;
        int length = s.length();

        for (end = 0; end < length; end++) {
            char curr = s.toCharArray()[end];
            if (map.containsKey(curr)) {
                // 返回上一个重复字符的下一个位置
                start = Math.max(start, map.get(curr) + 1);
            }
            // 加入字符和他的位置，当遇到重复字符会更新 end 的值
            map.put(curr, end);
            // 更新最大不重复的子串
            max = Math.max(max, end - start + 1);

        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abc abcbb";
        lengthOfLongestSubstring(str);
    }
}
