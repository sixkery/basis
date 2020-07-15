package com.sixkery.properties;

/**
 * @author sixkery
 */
public class AuthenticationProperties {

    private WxProperties wx = new WxProperties();

    private JwtProperties jwt = new JwtProperties();

    private MobileProperties mobile = new MobileProperties();

    public void setWx(WxProperties wx) {
        this.wx = wx;
    }

    public void setJwt(JwtProperties jwt) {
        this.jwt = jwt;
    }

    public void setMobile(MobileProperties mobile) {
        this.mobile = mobile;
    }

    public WxProperties wx() {
        return wx;
    }

    public JwtProperties jwt() {
        return jwt;
    }

    public MobileProperties mobile() {
        return mobile;
    }
}
