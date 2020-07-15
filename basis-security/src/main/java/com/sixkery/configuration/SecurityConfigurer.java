package com.sixkery.configuration;


/**
 * Create by Maoning in 2019/11/12
 */
public interface SecurityConfigurer<O, B extends SecurityBuilder<O>> {

    void init(B builder);

    void configure(B builder);

}
