package com.kevin.demo.exception;

import com.kevin.demo.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHander1 {

    private static final Logger Log = LoggerFactory.getLogger(ExceptionHander1.class);

    @ExceptionHandler
    public Result<String> handleException(Exception e) {
        Log.error("System error!", e);
        return new Result<>(500, "System error...", null);
    }

    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException e) {
        Log.warn("Business error: {} ", e.getMessage());
        return new Result<>(400, e.getMessage(), null);
    }
}
