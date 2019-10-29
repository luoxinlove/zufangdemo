package lx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lx.dao.TypeMapper;
import lx.entity.PageUtil;
import lx.entity.Type;
import lx.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    public TypeMapper typeMapper;

    @Override
    public List<Type> getAllDistrict() {
        return typeMapper.selectByExample();
    }

    @Override
    public PageInfo<Type> getTypeByPage(PageUtil PageInfo) {
        //开启分页
        PageHelper.startPage(PageInfo.getPage(),PageInfo.getRows());

        //查询所有
        List<Type> districts = typeMapper.selectByExample();

        //获取分页信息
        PageInfo<Type> pageInfo = new PageInfo(districts);
        return pageInfo;
    }

    @Override
    public int findtianjia(Type district) {
        return typeMapper.tianjia(district);
    }

    @Override
    public int findxiugai(Type district) {
        return typeMapper.xiugai(district);
    }

    @Override
    public Type findchaxunid(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int findshanchu(Integer id) {
        return typeMapper.shanchu(id);
    }

    @Override
    public int findshanchus(Integer[] ids) {
        return typeMapper.shanchus(ids);
    }
}
