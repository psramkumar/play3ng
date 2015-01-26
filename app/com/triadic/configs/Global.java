package com.triadic.configs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * --------------------------------------------------------------------------------------------------
 *
 * @desc Play Framework Global Settings, intent to perform start up and shutdown operation
 * @author Ramkumar Pillai
 * @url: http://www.triadic.net
 * @email psramkumar@triadic.net
 * @copyrights Triadic Technology holds all its credit
 * -----------------------------------------------------------------------------------------------------
 * @since 04 OCT 2014
 */

public class Global extends play.GlobalSettings {
    private GenericApplicationContext context;

    @Override
    public void beforeStart(play.Application application) {
        closeSpringContext();
    }

    @Override
    public void onStart(play.Application app) {
        super.onStart(app);

        context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        return context.getBean(clazz);
    }

    @Override
    public void onStop(play.Application application) {
        closeSpringContext();
    }

    private void closeSpringContext() {
        if (context != null) {
            context.close();
        }
    }
}
