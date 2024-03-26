package org.frank.spring.boot.controller.advice.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

//@ControllerAdvice可以与@ModelAttribute注解一起使用，将一些公共的模型数据添加到所有控制器方法的模型对象中。
@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to My App");
    }
}
