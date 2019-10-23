package com.qf.demo.controller;

import com.qf.demo.entity.TUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YinZhi
 */
@Controller
@RequestMapping("page")
@Slf4j
public class PageController {

    //private Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("hello")
    public String hello(Model model){
        //制造一个异常
        //int i = 1/0;

        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        TUser tUser = new TUser(1,"zs","zs123");
        model.addAttribute("tUser",tUser);
        int money = 10000;
        model.addAttribute("money",money);
        List<TUser> list = new ArrayList<>();
        TUser tUser2 = new TUser(2,"ls","zs123");
        list.add(tUser);
        list.add(tUser2);
        model.addAttribute("list",list);
        model.addAttribute("now",new Date());

        return "hello";
    }
}
