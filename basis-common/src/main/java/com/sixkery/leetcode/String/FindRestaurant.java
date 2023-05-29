package com.sixkery.leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 599. 两个列表的最小索引总和
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，
 * list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *  
 * <p>
 * created by sixkery on 2022/3/14.
 *
 * @author sixkery
 */
public class FindRestaurant {

    /**
     * 暴力求解
     * 我们需要记录 最小索引和，具体地，我们可以先遍历 list1，再在 list2 中找到相同的字符串，如果存在，
     * 则让两者的索引相加，与最小索引和对比，如果小，则替换之并清除结果集且把当前值加入结果集，如果相等，则加入结果集。
     */
    public static String[] findRestaurant(String[] list1, String[] list2) {

        int min = Integer.MAX_VALUE;
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j == min) {
                        resultList.add(list1[i]);
                    } else if (i + j < min) {
                        // 替换掉当前的值
                        min = i + j;
                        resultList.clear();
                        resultList.add(list1[i]);
                    }
                }

            }

        }
        return resultList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        final String[] restaurant = findRestaurant(list1, list2);
        System.out.println("restaurant = " + Arrays.toString(restaurant));

    }
}
