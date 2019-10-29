package lx.service;

import com.github.pagehelper.PageInfo;
import lx.entity.UserCondition;
import lx.entity.Users;

public interface UsersService {

    /*分页模糊查询*/
    PageInfo<Users> getUserByCondition(UserCondition condition);

    /*用户注册*/
    int addUser(Users users);

    /*检查用户名是否存在*/
    int checkUserName(String name);

    /*实现用户登入*/
    Users  login(String name,String password);
}
