package com.yuepeng.valid;

import cn.hutool.core.lang.Validator;
import com.yuepeng.valid.anno.Mobile;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName: MobileValidator
 * @Description:
 * @Author: wuzhiqiang
 * @Date: 2020-04-07 10:14
 * @Copyright
 **/
public class MobileValidator implements ConstraintValidator<Mobile, Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        return Validator.isMobile((String) value);
    }
}