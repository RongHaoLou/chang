package com.chang.web.controller.base;

import com.chang.facade.dto.ResponseDTOWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionController {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({Exception.class})
    protected ResponseDTOWrapper allException(Exception ex) {
        ResponseDTOWrapper responseDTOWrapper = new ResponseDTOWrapper();
        responseDTOWrapper.setSuccess(false);
        responseDTOWrapper.setMessage(ex.getMessage());
        return responseDTOWrapper;
    }

    /**
     * 处理所有接口数据验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseDTOWrapper handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();

        LOGGER.error(bindingResult.getFieldError().getDefaultMessage(), e);
        String errorMesssage = "Invalid Request:";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getDefaultMessage() + ", ";
        }
        ResponseDTOWrapper responseDTOWrapper = new ResponseDTOWrapper();
        responseDTOWrapper.setSuccess(false);
        responseDTOWrapper.setMessage(errorMesssage);
        return responseDTOWrapper;
    }
}
