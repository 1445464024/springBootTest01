package com.qf.demo.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.demo.pojo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.ibatis.binding.BindingException;

/**
 * @author YinZhi
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //全局异常处理，相当于默认处理机制
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handlerException(Exception e){
        //1.将错误信息记录下来
        log.error(e.getMessage());
        //2.如果是非常重要的核心业务
        //主动通知相关的负责人，系统出bug了，赶紧看看日志
        //发短信，发邮件

        //2.给用户反馈
        return new ResultBean("sorry","服务器繁忙,请稍后再试!");
    }

    //针对特定场景的异常，此处为数据校验异常，定制化的处理机制
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean validationErrorHandler(BindException e) throws JsonProcessingException {
        //1.先获取BindingResult
        BindingResult bindingResult = e.getBindingResult();
        //2.获取错误信息
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        //3.组装异常信息
        Map<String,String> message = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            message.put(field,defaultMessage);
        }
        //4.将map转化为json
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(message);

        //5.返回错误信息
        return new ResultBean("400",json);
    }
}
