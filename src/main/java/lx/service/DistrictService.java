package lx.service;

import com.github.pagehelper.PageInfo;
import lx.entity.District;
import lx.entity.PageUtil;

import java.util.List;

public interface DistrictService {

    List<District> getAllDistrict();


    //分页查询
    PageInfo<District> getDistrictByPage(PageUtil PageInfo);

    //添加
    int findtianjia(District district);

    //修改
    int findxiugai(District district);

    //id查询
    District findchaxunid(Integer id);

    //id删除
    int findshanchu(Integer id);

    //批量删除
    int findshanchus(Integer[] ids);
}
