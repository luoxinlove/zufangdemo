package lx.pcontroller;

import lx.entity.District;
import lx.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value ="typeController4" )
@RequestMapping("/page/")
public class DistrictController {

    @Autowired
    public DistrictService districtService;

    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllDistrict(){
        return  districtService.getAllDistrict();
    }
}
