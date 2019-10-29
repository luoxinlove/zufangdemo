package lx.pcontroller;

import lx.service.TypeService;
import lx.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value ="typeController3" )
@RequestMapping("/page/")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("selType")
    @ResponseBody
    public List<Type> selType(){
        return typeService.getAllDistrict();
    }


}
