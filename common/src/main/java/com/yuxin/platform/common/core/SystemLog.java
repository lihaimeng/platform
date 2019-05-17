package com.yuxin.platform.common.core;

import java.lang.annotation.*;

/**
 * @author jyh
 * @create 2018-03-29-15:08
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    String description() default "";

}
