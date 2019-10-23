package com.qf.demo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.qf.demo.config.Resource;
import com.qf.demo.entity.TUser;
import com.qf.demo.entity.User;
import com.qf.demo.pojo.ResultBean;
import com.qf.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


/**
 * @author YinZhi
 */
@RestController
@RequestMapping("hello")
@Slf4j
public class hello {

    /*@Value("${image.server}")
    private String imageServer;*/

    @Autowired
    private Resource resource;
    @Autowired
    private IUserService userService;

    @RequestMapping("hello")
    public String Hello(){
        return "hello!";
    }

    @GetMapping("getImageServer")
    public String getImageServer(){
        return resource.getImageServer();
    }

    @GetMapping("{id}")
    public TUser getById(@PathVariable Integer id){
        System.out.println("id="+id);
        System.out.println("查询操作");

        return userService.getById(id);
    }

    @DeleteMapping("{id}")
    public User delById(@PathVariable Long id){
        System.out.println("id="+id);
        System.out.println("删除操作");

        return new User(id,null,new Date());
    }

    /*@PostMapping("add")
    public String postUser(User user){
        System.out.println(user.getEntryDate());

        return "ok";
    }*/

    /*@PostMapping("add")
    public ResultBean postUser(@Valid User user, BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Map<String,String> result = new HashMap<>();
            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();

                log.error("[{}]:[{}]",field,defaultMessage);
                result.put(field,defaultMessage);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            //将对象转换为json
            String json = objectMapper.writeValueAsString(result);

            return new ResultBean("faild",json);
        }
        //System.out.println(user.getEntryDate());
        log.info("模拟实现用户的添加");
        return new ResultBean("success","ok");
    }*/

    @PostMapping("add")
    public ResultBean add(@Valid User user) throws JsonProcessingException {
        //AOP 将核心业务逻辑和非核心业务逻辑做分离
        //1，核心业务逻辑：做用户数据的添加
        //2，非核心业务逻辑：做数据格式的校验

        //事务的控制
        //核心业务：做数据的添加操作
        //非核心业务：做事务控制
        log.info("模拟实现了用户的添加");
        return new ResultBean("success","ok");
    }

    /*@GetMapping("getImageServer")
    public String getImageServer1(){
        return imageServer;
    }*/
}
