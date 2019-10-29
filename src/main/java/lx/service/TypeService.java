package lx.service;

import com.github.pagehelper.PageInfo;
import lx.entity.PageUtil;
import lx.entity.Type;

import java.util.List;

public interface TypeService {

    //查询所有
    List<Type> getAllDistrict();


    //分页查询
    PageInfo<Type> getTypeByPage(PageUtil PageInfo);

    //添加
    int findtianjia(Type district);

    //修改
    int findxiugai(Type district);

    //id查询
    Type findchaxunid(Integer id);

    //id删除
    int findshanchu(Integer id);

    //批量删除
    int findshanchus(Integer[] ids);
}
