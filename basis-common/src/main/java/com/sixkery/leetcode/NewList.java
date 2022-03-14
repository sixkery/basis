package com.sixkery.leetcode;


/**
 * 手动实现 list
 * created by sixkery on 2022/3/10.
 */
public class NewList {

    private Object[] elementData;
    private int size;

    public NewList() {
        this(10);

    }

    public NewList(int init) {
        if (init <= 0) {
            System.out.println("抛异常");
        }
        elementData = new Object[init];
    }

    public void add(Object o) {
        if (size >= elementData.length) {
            capacity();
        }
        elementData[size++] = o;
    }
    public void get() {}

    /**
     * 扩容方法
     */
    public void capacity() {
        Object[] newElementData = new Object[elementData.length + (elementData.length >> 1)];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
    }


}
