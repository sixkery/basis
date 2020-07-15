package com.sixkery.configuration;

import javax.servlet.Filter;

/**
 * Create by Maoning in 2019/11/12
 */
public class WebSecurity extends AbstractConfiguredSecurityBuilder<Filter, WebSecurity> {

    private SecurityBuilder<? extends Filter> securityBuilder;

    @Override
    protected Filter doBuild() {
        return securityBuilder.build();
    }

    public void setSecurityBuilder(SecurityBuilder<? extends Filter> securityBuilder) {
        this.securityBuilder = securityBuilder;
    }
}
