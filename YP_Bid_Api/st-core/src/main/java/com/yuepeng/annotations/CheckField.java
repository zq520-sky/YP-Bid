package com.yuepeng.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 〈功能概述〉<br>
 *
 * @className: Required
 * @package: com.yuepeng.annotations
 * @author: wzq
 * @date: 2020/5/26 12:03
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CheckField {
}
