package com.riya.JobAppReactUsingSpringBoot.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);



    @Before("execution (* com.riya.JobAppReactUsingSpringBoot.service.JobService.viewAllJobs(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution (* com.riya.JobAppReactUsingSpringBoot.service.JobService.viewAllJobs(..))")
    public void logMethodCall1(JoinPoint jp) {
        LOGGER.info("Method Called Done " + jp.getSignature().getName());
    }
}
