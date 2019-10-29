package lx.dao;

import lx.entity.District;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    @Select("select * from district")
    List<District> selectByExample();

    @Insert("insert into district values (NULL,#{name});")
    int tianjia(District district);

    @Update("update district set NAME=#{name} where ID=#{id};")
    int xiugai(District district);

    @Delete("delete from district where id=#{id};")
    int shanchu(Integer id);

    @Delete("delete from street where DISTRICT_ID=#{DISTRICT_ID};")
    int jiedaoshanchu(Integer DISTRICT_ID);


    int shanchus(Integer[] ids);
}