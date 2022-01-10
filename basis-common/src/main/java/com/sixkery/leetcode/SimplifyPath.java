package com.sixkery.leetcode;

import java.util.Stack;

/**
 * 71.简化路径
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> pathStack = new Stack<>();

        String[] pathList = path.split("/");
        for (String s : pathList) {

        }

        return path.replace("//", "/");
    }

    public static void main(String[] args) {



        String path = "/home/";
        String result = simplifyPath(path);
        System.out.println("result = " + result);


    }
}
