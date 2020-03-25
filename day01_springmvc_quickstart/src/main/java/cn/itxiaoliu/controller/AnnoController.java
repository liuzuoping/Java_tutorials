package cn.itxiaoliu.controller;

import cn.itxiaoliu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了");
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了");
        System.out.println(cookieValue);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute执行了");
        System.out.println(user);
        return "success";
    }
    @ModelAttribute
    public User showUser(String uname){
        System.out.println("ShowUser执行了。。。。");
        User user=new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes执行了");
        model.addAttribute("msg","美美" );
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes执行了");
        String msg= (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes执行了");
        status.setComplete();
        return "success";
    }
}
