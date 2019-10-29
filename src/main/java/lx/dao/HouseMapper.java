package lx.dao;

import lx.entity.House;
import lx.entity.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    //添加方法
    int insertSelective(House house);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //连表查询
    List<House> getHouseByUser(Integer userid);

    //查询某条出租房信息
    House getHouseById(String id);

    //查询所有未审核的出租房
    List<House> getHouseByPassState(Integer state);

    //审核出租房  修该出租房的审核状态  0未审核  1已审核
    public int updateHousePassState(String id,Integer state);

    //浏览出租房
    List<House> getHouseByBroswer(HouseCondition condition);
}