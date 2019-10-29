package lx.dao;

import lx.entity.Type;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    @Select("select * from type")
    List<Type> selectByExample();

    @Insert("insert into type values (NULL,#{name});")
    int tianjia(Type type);

    @Update("update type set NAME=#{name} where ID=#{id};")
    int xiugai(Type type);

    @Delete("delete from type where id=#{id};")
    int shanchu(Integer id);

    int shanchus(Integer[] ids);
}