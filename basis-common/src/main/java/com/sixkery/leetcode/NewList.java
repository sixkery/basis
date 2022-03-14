package com.sixkery.leetcode;


/**
 * 手动实现 list
 * created by sixkery on 2022/3/10.
 */
public class NewList {

    private Object[] elementData;
    private int size;

    public NewList() {

    }

    public NewList(int init) {
        if (init <= 0) {
            System.out.println("抛异常");
        }
        elementData = new Object[init];
    }
}
