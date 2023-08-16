package com.sixkery.leetcode.String;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author sixkery
 * @since 2023/8/14
 */
public class TestParams {
    public static void main(String[] args) {
//        int n = 5;
//        System.out.println("n 的初始值为：" + n);
//        add(n);
//        System.out.println("n 的最终值为：" + n);

         ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

         HashSet<Integer> objects = new HashSet<>();

        objects.add(1);
        objects.add(2);
        objects.add(3);

        HashSet<Integer> listset = new HashSet<>(list);

        for (Integer object : objects) {
            if (listset.add(object)){
                list.add(object);
            }
        }


        System.out.println("listset = " + list);




    }
    public static void add(int n) {
        n = n + 1;
        System.out.println("add 方法的值 = " + n);
    }
}
