package com.sixkery.configuration;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractConfiguredSecurityBuilder<O, B extends SecurityBuilder<O>> implements SecurityBuilder<O> {

    private List<SecurityConfigurer<O, B>> configurers = new ArrayList<>();

    @Override
    public O build() {

        init();

        configure();

        return doBuild();
    }

    protected <C extends SecurityConfigurerAdapter<O, B>> void apply(C configurer) {
        configurer.setBuilder((B) this);
        configurers.add(configurer);
    }

    protected <C extends SecurityConfigurer<O, B>> void apply(C configure) {
        configurers.add(configure);
    }

    /**
     * 具体对象的构建交给派生类完成
     * @return
     */
    protected abstract O doBuild();

    protected List<SecurityConfigurer<O, B>> getConfigurers() {
        return this.configurers;
    }

    /**
     * 调用全部子类的init方法
     */
    private void init() {
        for (SecurityConfigurer<O, B> configurer : getConfigurers()) {
            configurer.init((B) this);
        }
    }

    /**
     * 调用全部子类的configure方法
     */
    private void configure() {
        for (SecurityConfigurer<O, B> configurer : getConfigurers()) {
            configurer.configure((B) this);
        }
    }
}
