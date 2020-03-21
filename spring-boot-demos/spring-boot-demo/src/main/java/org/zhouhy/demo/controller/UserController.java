package org.zhouhy.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.zhouhy.demo.entity.Address;
import org.zhouhy.demo.entity.User;
import org.zhouhy.demo.service.AddressService;
import org.zhouhy.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value={"/login","/login.html","/",""})
    public String loginPage(HttpSession session, HttpServletRequest request, @RequestParam(name = "ac",required = false) String ac){
        if(null!=ac && ac.equals("1")){
            request.setAttribute("loginErr","Please login");
        }

        if(null!=ac && ac.equals("2")){
            request.setAttribute("loginErr","username or password is invalid");
        }

        if(session.getAttribute("loginUser") == null){
            return "login";
        }else{
            return "main";
        }
    }

    @RequestMapping(value={"/userlist.html"},method = RequestMethod.GET)
    public String userListPage(Model model){
        List<User> userList = userService.findAllUsers();
        Map<String,Object> asMap = model.asMap();
        if(asMap!=null && asMap.get("users")!=null){
            return "userlist";
        }
        model.addAttribute("users",userList);
        System.out.println(model.asMap().get("users"));
        return "userlist";
    }

    @RequestMapping(value={"/main.html"},method = RequestMethod.GET)
    public String mainPage1(){
        return "main";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession httpSession){
        boolean isLoginSuccess = userService.login(user);
        if(isLoginSuccess){
            httpSession.setAttribute("loginUser","login");
            return "redirect:/main.html";
        }

        model.addAttribute("loginErr","username or password is invalid");
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
        return "redirect:/login.html?ac=2";
    }

    @RequestMapping(value="/searchUser",method = RequestMethod.POST)
    public String searchUser(User user, Model model){
        List<User> users = userService.findUserByUsernameLike("%"+user.getUsername()+"%");
        model.addAttribute("users",users);
        return "userlist";
    }

    @RequestMapping(value="addUser.html",method=RequestMethod.GET)
    public String addUserPage(Model model){
        List<Address> addressList = addressService.getAllAddress();
        model.addAttribute("addresses",addressList);
        return "adduser";
    }


    @RequestMapping(value="adduser",method=RequestMethod.POST)
    public String addUser(User user){
        Address address = addressService.getOne(user.getAddress().getId());
        user.setAddress(address);
        user.setRegDate(new Date());
        userService.saveUser(user);
        return "redirect:/userlist.html";
    }

    @RequestMapping(value="updateuser.html",method=RequestMethod.GET)
    public String updateUserPage(Integer id,Model model){
        User user = userService.getOneUser(id);
        model.addAttribute("user",user);
        List<Address> addressList = addressService.getAllAddress();
        model.addAttribute("addresses",addressList);
        return "updateuser";
    }

    /**
     * 这里的user其实并没有把address的全部消息存储进去，只是存了个id,然后JPA的机制会根据这个id来找到相应的address
     * 并更新到数据库中去
     * */
    @RequestMapping(value="updateuser",method=RequestMethod.POST)
    public String updateUser(User user){
//        User u = userService.getOneUser(user.getId());
//        Address address = addressService.getOne(user.getAddress().getId());
//
//        u.setRegDate(user.getRegDate());
//        u.setAddress(address);
        log.info(user.toString());
        userService.updateUser(user);
        return "redirect:/userlist.html";
    }
}
