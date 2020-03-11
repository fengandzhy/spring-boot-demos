package org.zhouhy.springboot.freemarker.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.zhouhy.springboot.freemarker.entity.User;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class IndexController {

    @GetMapping(value = "/users")
    public String index(Model model){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"aaa","aaa123"));
        userList.add(new User(1,"bbb","bbb123"));
        userList.add(new User(1,"ccc","ccc123"));
        model.addAttribute("users",userList);
        return "index";
    }
}
