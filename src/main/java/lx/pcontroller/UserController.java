package lx.pcontroller;

import lx.entity.Users;
import lx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller(value ="userController2" )
@RequestMapping("/page/")
public class UserController {

    @Autowired
    private UsersService userService;

    //注册
    @RequestMapping("reg")
    public String reg(Users users){
        int temp=userService.addUser(users);
        if(temp>0)
        return "login";  //登入页
        else
            return "regs";  //注册页
    }

    //检查用户名
    @RequestMapping("checkName")
    @ResponseBody  //{"result":1|0}
    public String checkName(String name){
         //调用业务
        int falg=userService.checkUserName(name);
        return "{\"result\":"+falg+"}";
    }

    //注册
    @RequestMapping("loginAction")
    public String loginAction(String name, String password, HttpSession session){
        Users user=userService.login(name,password);
        if(user!=null) {
           //就使用session保存登入的人
            session.setAttribute("userinfo",user);
            //设置session的有效期
            session.setMaxInactiveInterval(600);  //10分钟
            return "redirect:getUserHouse";  //后台管理页
        }else
            return "login";  //登入页
    }


}
