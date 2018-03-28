package com.chang.web.controller.base;

import com.chang.facade.dto.ResponseDTOWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        List<ObjectError> fieldErrors = e.getBindingResult().getAllErrors();
        Map<String, String> errors = new HashMap<>(fieldErrors.size());
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ResponseDTOWrapper responseDTOWrapper = new ResponseDTOWrapper();
        responseDTOWrapper.setSuccess(false);
        responseDTOWrapper.setMessage(errors.toString());
        return responseDTOWrapper;
    }

    /**
     * 数据库错误
     * @param ex
     * @return
     */
    @ExceptionHandler({ConstraintViolationException.class})
    protected ResponseDTOWrapper constraintViolationException(ConstraintViolationException ex) {
        LOGGER.error(ex.getLocalizedMessage());
        Set<ConstraintViolation<?>> result = ex.getConstraintViolations();
        Map<String, String> errors = new HashMap<>(result.size());
        for (ConstraintViolation violation : result) {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        ResponseDTOWrapper responseWrapperDTO = new ResponseDTOWrapper();
        responseWrapperDTO.setSuccess(false);
        responseWrapperDTO.setMessage(errors.toString());
        return responseWrapperDTO;
    }
}
