package com.sixkery.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private AuthorizeProperties authorize = new AuthorizeProperties();

    @NestedConfigurationProperty
    private AuthenticationProperties authentication = new AuthenticationProperties();

    public void setAuthorize(AuthorizeProperties authorize) {
        this.authorize = authorize;
    }

    public void setAuthentication(AuthenticationProperties authentication) {
        this.authentication = authentication;
    }

    public AuthorizeProperties authorize() {
        return authorize;
    }

    public AuthenticationProperties authentication() {
        return authentication;
    }
}
