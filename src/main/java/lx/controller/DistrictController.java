package lx.controller;

import com.github.pagehelper.PageInfo;
import lx.entity.District;
import lx.entity.PageUtil;
import lx.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class DistrictController {

    @Autowired
    public DistrictService districtService;


    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllDistrict(){
        return  districtService.getAllDistrict();
    }


    @RequestMapping("getDistrictBypage")
    @ResponseBody
    public Map<String,Object> getDistrictBypage(PageUtil pageUtil){

        //调用业务
        PageInfo<District> pageInfo = districtService.getDistrictByPage(pageUtil);

        //使用Map封装返回数据
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("addDistrict")
    @ResponseBody
    public Map<String,Object> addDistrict(District district){
        //调用业务
        int flag = districtService.findtianjia(district);

        //使用map封装返回的数据
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("result",flag);
        return map;
    }


    @RequestMapping("selectid")
    @ResponseBody
     public District selectid(Integer id){
        District dis = districtService.findchaxunid(id);
        return dis;
    }

    @RequestMapping("updateDistrict")
    @ResponseBody
    public Map<String,Object> updateDistrict(District district){
        int flag = districtService.findxiugai(district);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("result",flag);
        return map;
    }

    @RequestMapping("deleteDistrict")
    @ResponseBody
    public Map<String,Object> deleteDistrict(Integer id){
        int i1 = districtService.findshanchu(id);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("result",i1);
        return map;
    }

    /*批量删除区域*/
    @RequestMapping("piliangshanchu")
    @ResponseBody
    public Map<String,Object> piliangshanchu(String ids) {
        /*调用业务
        * 将字符串转化为数组
        * */
        String[] list=ids.split(",");
        Integer[] ary=new Integer[list.length];
        for (int i=0 ; i<list.length;i++){
            ary[i]=Integer.parseInt(list[i]);
        }
        //调用业务
        int i1 = districtService.findshanchus(ary);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", i1);
        return map;

    }
}


