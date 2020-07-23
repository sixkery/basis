package com.sixkery.configuration;

import javax.servlet.Filter;

public interface WebSecurityConfigurer<B extends SecurityBuilder<Filter>> extends SecurityConfigurer<Filter, B> {
}
