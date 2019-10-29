package lx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lx.dao.HouseMapper;
import lx.entity.House;
import lx.entity.HouseCondition;
import lx.entity.PageUtil;
import lx.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    public HouseMapper houseMapper;

    @Override
    public int insertSelective(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public List<House> getHouseByUserid(Integer userid) {
        return houseMapper.getHouseByUser(userid);
    }

    @Override
    public House getHouseById(String id) {
        return houseMapper.getHouseById(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delHouse(String id,Integer state) {
        /*创建实体对象*/
        House house=new House();
        /*设置房屋编号*/
        house.setId(id);
        //设置删除状态
        house.setIsdel(state);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseByPassSate(Integer state, PageUtil pageUtil) {
        //开启分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        //查询所有
        List<House> list=houseMapper.getHouseByPassState(state);
        return new PageInfo<House>(list);
    }

    @Override
    public int updateHousePassState(String id, Integer state) {
        House  house=new House();
        house.setId(id); //编号
        house.setIspass(state); //审核状态
        return this.houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseByBroswer(HouseCondition condition) {
        //开启分页
        PageHelper.startPage(condition.getPage(),condition.getRows());
        //查询所有
        List<House> list = this.houseMapper.getHouseByBroswer(condition);
        //获取分页信息
        PageInfo<House> pageInfo = new PageInfo<House>(list);
        return pageInfo;

    }
}
