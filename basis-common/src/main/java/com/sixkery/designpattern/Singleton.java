package com.sixkery.designpattern;

/**
 * @author sixkery
 * @since 2024/12/30
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized(Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
