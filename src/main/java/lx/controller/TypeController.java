package lx.controller;

import com.github.pagehelper.PageInfo;
import lx.entity.PageUtil;
import lx.entity.Type;
import lx.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class TypeController {


    @Autowired
    public TypeService typeService;


    @RequestMapping("getAllType")
    @ResponseBody
    public List<Type> getAllType(){
        return  typeService.getAllDistrict();
    }


    @RequestMapping("getTypeBypage")
    @ResponseBody
    public Map<String,Object> getTypeBypage(PageUtil pageUtil){

        //调用业务
        PageInfo<Type> pageInfo = typeService.getTypeByPage(pageUtil);

        //使用Map封装返回数据
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("addType")
    @ResponseBody
    public Map<String,Object> addDistrict(Type district){
        //调用业务
        int flag = typeService.findtianjia(district);

        //使用map封装返回的数据
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("result",flag);
        return map;
    }


    @RequestMapping("selectTypeid")
    @ResponseBody
    public Type selectid(Integer id){
        Type dis = typeService.findchaxunid(id);
        return dis;
    }

    @RequestMapping("updateType")
    @ResponseBody
    public Map<String,Object> updateDistrict(Type district){
        int flag = typeService.findxiugai(district);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("result",flag);
        return map;
    }

    @RequestMapping("deleteType")
    @ResponseBody
    public Map<String,Object> deleteType(Integer id){
        int i1 = typeService.findshanchu(id);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("result",i1);
        return map;
    }

    /*批量删除区域*/
    @RequestMapping("Typepiliangshanchu")
    @ResponseBody
    public Map<String,Object> Typepiliangshanchu(String ids) {
        /*调用业务
         * 将字符串转化为数组
         * */
        String[] list=ids.split(",");
        Integer[] ary=new Integer[list.length];
        for (int i=0 ; i<list.length;i++){
            ary[i]=Integer.parseInt(list[i]);
        }
        //调用业务
        int i1 = typeService.findshanchus(ary);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", i1);
        return map;

    }
}
