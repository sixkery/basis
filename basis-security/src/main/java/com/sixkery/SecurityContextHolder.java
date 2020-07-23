package com.sixkery;

public class SecurityContextHolder {

    private static SecurityContextHolderStrategy strategy;

    static {
        strategy = new ThreadLocalSecurityContextHolderStrategy();
    }

    public static SecurityContext getContext() {
        return strategy.getContext();
    }

    public static void clearContext() {
        strategy.clearContext();
    }

}
