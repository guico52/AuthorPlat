package com.guico.authorplat.interceptor;

import DTO.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor  {
    @ExceptionHandler
    public Result exceptionHandler(Exception e) {
        return Result.fail(e.getMessage());
    }
}
