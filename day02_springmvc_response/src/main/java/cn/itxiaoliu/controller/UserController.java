package cn.itxiaoliu.controller;

import cn.itxiaoliu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了");
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(30);
        model.addAttribute("user",user );
        return "success";
    }
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid执行了");
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response );

        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");
        return;
    }
    @RequestMapping("/testModelAndView")
    public String testModelAndView(){
        ModelAndView mv=new ModelAndView();
        System.out.println("testModelAndView方法执行了");
        User user = new User();
        user.setUsername("小风");
        user.setPassword("456");
        user.setAge(30);
        mv.addObject("user",user);
        mv.setViewName("success");
        return String.valueOf(mv);
    }
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了");
        //return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/index.jsp";
    }

//    @RequestMapping("/testAjax")
//    public void testAjax(@RequestBody String body){
//        System.out.println("testAjax方法执行了");
//        System.out.println(body);
//    }
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了");
        System.out.println(user);
        user.setUsername("haha");
        user.setAge(40);
        return user;
    }
}
