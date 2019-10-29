package lx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lx.dao.UsersMapper;
import lx.entity.MD5Utils;
import lx.entity.UserCondition;
import lx.entity.Users;
import lx.entity.UsersExample;
import lx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    public UsersMapper usersMapper;

    @Override
    public PageInfo<Users> getUserByCondition(UserCondition condition) {
        //1.开启分页
        PageHelper.startPage(condition.getPage(),condition.getRows());

        //2.查询所有用户
        UsersExample usersExample=new UsersExample();
        //使用Criteria封装查询条件
        UsersExample.Criteria criteria = usersExample.createCriteria();

        //添加条件
        if(condition.getName()!=null) {
            criteria.andNameLike("%"+condition.getName().trim()+"%");
        }
        if(condition.getTelephone()!=null) {
            criteria.andTelephoneLike("%"+condition.getTelephone().trim()+"%");
        }
        List<Users> list=this.usersMapper.selectByExample(usersExample); //查询
        return new PageInfo<Users>(list);
    }

    @Override
    public int addUser(Users users) {
        //使用md5工具类对密码加密码
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));

        //设置isadmin默认为0
        users.setIsadmin(0);
        return usersMapper.insertSelective(users);
    }

    @Override
    public int checkUserName(String name) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria= usersExample.createCriteria();
        //用户名条件
        criteria.andNameEqualTo(name);
        //执行
        List<Users> list=usersMapper.selectByExample(usersExample);
        return list.size();
    }

    @Override
    public Users login(String name, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria= usersExample.createCriteria();
        //用户名和密码条件
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        //执行
        List<Users> list=usersMapper.selectByExample(usersExample);
        if(list.size()==0)
            return null;
        else
            return list.get(0);
    }
}
