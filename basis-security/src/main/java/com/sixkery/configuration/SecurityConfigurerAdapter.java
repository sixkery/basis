package com.sixkery.configuration;


public abstract class SecurityConfigurerAdapter<O, B extends SecurityBuilder<O>> implements SecurityConfigurer<O, B> {

    private B builder;

    public void setBuilder(B builder) {
        this.builder = builder;
    }

    public B getBuilder() {
        return builder;
    }

    public B and() {
        return getBuilder();
    }

    @Override
    public void init(B builder) {

    }

    @Override
    public void configure(B builder) {

    }
}
