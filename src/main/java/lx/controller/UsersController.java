package lx.controller;

import com.github.pagehelper.PageInfo;
import lx.entity.UserCondition;
import lx.entity.Users;
import lx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class UsersController {

    @Autowired
    public UsersService usersService;


    @RequestMapping("getUserByPage")
    @ResponseBody
    public Map<String,Object> getUserByPage(UserCondition userCondition){

        PageInfo<Users> pageInfo = usersService.getUserByCondition(userCondition);

        //使用Map封装返回数据
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }
}
