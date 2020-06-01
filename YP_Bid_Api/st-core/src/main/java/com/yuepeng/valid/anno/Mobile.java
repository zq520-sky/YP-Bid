package com.yuepeng.valid.anno;

/**
 * @ClassName: Mobile
 * @Description: 手机号校验
 * @Author: wuzhiqiang
 * @Date: 2020-04-07 10:13
 * @Copyright
 **/
import com.yuepeng.valid.MobileValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = MobileValidator.class)
public @interface Mobile {

    // flag无效时的提示内容
    String message() default "手机号格式错误！";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}