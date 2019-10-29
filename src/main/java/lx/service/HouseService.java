package lx.service;

import com.github.pagehelper.PageInfo;
import lx.entity.House;
import lx.entity.HouseCondition;
import lx.entity.PageUtil;

import java.util.List;

public interface HouseService {

    //添加
    int insertSelective(House house);

    //连表查询
    List<House> getHouseByUserid(Integer userid);

    //查询某条出租房信息
    House getHouseById(String id);


    /*修改*/
    public int updateHouse(House house);

    /*删除输出房*/
    public int delHouse(String id,Integer state);

    //查询已审核|未审核的出租房信息
    public PageInfo<House> getHouseByPassSate(Integer state, PageUtil pageUtil);

    //修改出租房的审核状态
    public int updateHousePassState(String id,Integer state);

    //浏览所有出租房
    PageInfo<House> getHouseByBroswer(HouseCondition condition);
}
