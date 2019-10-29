package lx.dao;

import lx.entity.Street;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    @Select("select * from street where DISTRICT_ID=#{id};")
    List<Street> allid(Integer id);

}