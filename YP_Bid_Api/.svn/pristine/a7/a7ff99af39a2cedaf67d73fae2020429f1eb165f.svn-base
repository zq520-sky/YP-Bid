package com.yuepeng.dispose.exception;

import com.alibaba.fastjson.JSON;
import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.config.RUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.NodeImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.*;

/**
 * 异常处理器
 *
 * @author 
 */
@RestControllerAdvice
@Slf4j
public class RRExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RRException.class)
    public R handleRRException(RRException e){
        return RUtils.fail(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e){
        log.error(e.getMessage(), e);
        return RUtils.fail(1001,"数据库中已存在该记录");
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        log.error(e.getMessage(), e);
        return RUtils.fail(500, e.getMessage());
    }

    /**
     * 参数校验
     * @author: wuzhiqiang
     * @date: 2020/4/8
     * @param ex:
     * @return: com.yuepeng.dispose.common.R
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public R handleConstraintValidateException(ConstraintViolationException ex){
        log.error(ex.getMessage(), ex);
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        Map<Object, Object> res = new HashMap<>();
        while (iterator.hasNext()){
            ConstraintViolation<?> next = iterator.next();
            Path propertyPath = next.getPropertyPath();
            NodeImpl leafNode = ((PathImpl) propertyPath).getLeafNode();
            String s = leafNode.asString();
            res.put(s, next.getMessage());
        }
        return RUtils.fail(500, JSON.toJSONString(res));
    }

    /**
     * 对象参数校验
     * @author: wuzhiqiang
     * @date: 2020/4/7
     * @param e:
     * @return: com.yuepeng.dispose.common.R
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleParamValidException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors= e.getBindingResult().getFieldErrors();
        StringBuffer errMsg = new StringBuffer();
        fieldErrors.stream().forEach(fieldError -> {
            errMsg.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(";");
        });
        log.error(e.getMessage(), e);
        return RUtils.fail(500, errMsg.toString());
    }

}