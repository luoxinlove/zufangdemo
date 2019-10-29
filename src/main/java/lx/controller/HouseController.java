package lx.controller;

import com.github.pagehelper.PageInfo;
import lx.entity.House;
import lx.entity.HouseCondition;
import lx.entity.PageUtil;
import lx.service.HouseService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("getHouseNoPass")  //eastui datagrid自动传page,rows
    @ResponseBody
    public Map<String,Object> getHouseNoPass(PageUtil page){
        //调用业务    0表示未审核
        PageInfo<House> house=this.houseService.getHouseByPassSate(0,page);
        //返回数据
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("rows",house.getList());
        map.put("total",house.getTotal());
        return map;
    }

    @RequestMapping("goHousePass")
    @ResponseBody
    public String goHousePass(String id){
        //调用业务审核 1表示通过审核
        int temp=this.houseService.updateHousePassState(id,1);
        return "{\"result\":"+temp+"}";
    }

}
