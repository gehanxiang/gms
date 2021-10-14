package com.gms.providerUser.Retention;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Limit {

    String key() default "";

    double permitsPerSecond () ;

    long timeout();

    TimeUnit timeunit() default TimeUnit.MILLISECONDS;

    String msg() default "系统繁忙,请稍后再试.";
}
