package lx.pcontroller;

import lx.entity.Street;
import lx.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value ="typeController5" )
@RequestMapping("/page/")
public class StreetController {

    @Autowired
    public StreetService StreetService;


    @RequestMapping("allIDStreet")
    @ResponseBody
    public List<Street> allIDStreet(Integer id){

        return StreetService.findallid(id);
    }
}
