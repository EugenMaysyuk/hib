package com.may;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HibernateAspect {

    private static final Logger LOGGER = Logger.getLogger(HibernateAspect.class);

    /**
     * Pointcut
     *
     * */
    @Pointcut("execution(* org.hibernate.boot.internal.InFlightMetadataCollectorImpl.buildMetadataInstance(..))")
    public void hibernatePointcut() {
    }

    /**
     * Advice
     *
     * */
    @Before("hibernatePointcut()")
    public void beforeAdvice() {
        LOGGER.debug("HELLO ASPECTJ");
    }
}
