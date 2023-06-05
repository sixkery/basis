package com.sixkery.leetcode.code1_10;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sixkery
 * @since 2023/6/5
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] == target) {
//                return arr[left];
//            } else if (left > mid){
//
//
//            }
//        }
        return 1;
    }

    public static void main(String[] args) {
        List<String> collect = Stream.of("23MB", "23.23MB").collect(Collectors.toList());
        List<BigDecimal> mb = collect.stream().map(s -> BigDecimal.valueOf(Double.parseDouble(s.split("MB")[0])))
                        .
                collect(Collectors.toList());


        final BigDecimal mb1 = collect.stream().map(s -> BigDecimal.valueOf(Double.parseDouble(s.split("MB")[0])))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        final String s = mb1.toString();
        System.out.println("s = " + s);
        System.out.println("mb1 = " + mb1);

        System.out.println("mb1 = " + mb1);
        BigDecimal bigDecimal1 = new BigDecimal(0);
        for (BigDecimal bigDecimal : mb) {
            bigDecimal1 = bigDecimal1.add(bigDecimal);
        }
        System.out.println("bigDecimal1 = " + bigDecimal1);


//        System.out.println("result = " + result);
//        final BigDecimal mb1 = collect.stream().mapToDouble(s -> BigDecimal.valueOf(Double.parseDouble(s.split("MB")[0]))).sum();
        System.out.println("mb = " + mb);
//        System.out.println("mb = " + mb1);


        List<Double> list = Arrays.asList(111.0, 111.11, 111.11, 111.11);
        Double a = list.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println(a);

    }

}
