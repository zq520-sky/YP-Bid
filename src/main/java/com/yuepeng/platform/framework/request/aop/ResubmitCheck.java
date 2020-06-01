package com.yuepeng.platform.framework.request.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented 
public  @interface ResubmitCheck {
	
	 boolean checkFlag() default true;

}
