package com.sixkery.model;

import java.util.HashMap;

/**
 * @author sixkery
 * @since 2023/7/18
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        new HashMap<>()
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance == null) {

                instance = new Singleton();
            }
        }
        return instance;
    }
}
