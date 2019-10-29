package lx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lx.dao.DistrictMapper;
import lx.entity.District;
import lx.entity.PageUtil;
import lx.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    public DistrictMapper districtMapper;


    @Override
    public List<District> getAllDistrict() {
            return districtMapper.selectByExample();
    }


    @Override
    public int findtianjia(District district) {
        return districtMapper.tianjia(district);
    }

    @Override
    public PageInfo<District> getDistrictByPage(PageUtil PageInfo) {
        //开启分页
        PageHelper.startPage(PageInfo.getPage(),PageInfo.getRows());

        //查询所有
        List<District> districts = districtMapper.selectByExample();

        //获取分页信息
        PageInfo<District> pageInfo = new PageInfo(districts);
        return pageInfo;
    }

    @Override
    public int findxiugai(District district) {
        return districtMapper.xiugai(district);
    }

    @Override
    public District findchaxunid(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int findshanchu(Integer id) {
        districtMapper.jiedaoshanchu(id);
        districtMapper.shanchu(id);
        return 1;
    }

    @Override
    public int findshanchus(Integer[] ids) {

        return districtMapper.shanchus(ids);
    }
}
