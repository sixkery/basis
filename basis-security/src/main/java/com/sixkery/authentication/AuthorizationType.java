package com.sixkery.authentication;

public enum AuthorizationType {

    BEARER(1, "Bearer "), BASIC(2, "Basic ");

    private int value;

    private String prefix;

    AuthorizationType(int value, String prefix) {
        this.value = value;
        this.prefix = prefix;
    }

    public String prefix() {
        return this.prefix;
    }

    public int value() {
        return this.value;
    }

}
