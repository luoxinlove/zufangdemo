package lx.pcontroller;

import com.github.pagehelper.PageInfo;
import lx.entity.House;
import lx.entity.HouseCondition;
import lx.entity.Users;
import lx.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller(value ="typeController6" )
@RequestMapping("/page/")
public class HouseController {

    @Autowired
    public HouseService houseService;


    @RequestMapping("addHouse")
    public String addHouse(House house, HttpSession session, @RequestParam(value = "pfile",required = false)MultipartFile pfile){

        try {
            //1.上传文件
            String sourceFile = pfile.getOriginalFilename();//文件名

            String extName = sourceFile.substring(sourceFile.lastIndexOf("."));//扩展名

            String bh = System.currentTimeMillis() + "";
            String filename= bh+extName;
            String path ="d:\\images\\"+filename;
            File saveFile=new File(path);
            pfile.transferTo(saveFile);//上传

            //2.将数据保存到数据库
            //设置编号
            house.setId(bh);
            //设置图片
            house.setPath(filename);
            //设置用户编号
            Users user = (Users) session.getAttribute("userinfo");
            house.setUserId(user.getId());

            //调用业务
            houseService.insertSelective(house);
            return "redirect:getUserHouse";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("getUserHouse")
    public String getUserHouse(HttpSession session, Model model){
        //调用业务
        //获取用户编号
        Users user = (Users)session.getAttribute("userinfo");
        List<House> list = houseService.getHouseByUserid(user.getId());//

        model.addAttribute("list",list);


        return "guanli";
    }

    @RequestMapping("showHouse")
    public String showHouse(String id,Model model){
        //调用业务
        House house = houseService.getHouseById(id);
        model.addAttribute("house",house);

        return "upfabu";
    }

    @RequestMapping("updateHouse")
    public String updateHouse(House house,String oldpic,
                              @RequestParam(value = "pfile",required = false)MultipartFile pfile){
        try {
           /*判断用户是否选择修改图片*/
            if (!pfile.isEmpty()){

                //1.上传文件
                String sourceFile = pfile.getOriginalFilename();//文件名
                System.out.println(sourceFile);
                String extName = sourceFile.substring(sourceFile.lastIndexOf("."));//扩展名
                System.out.println(extName);
                String bh = System.currentTimeMillis() + "";
                String filename= bh+extName;
                String path ="d:\\images\\"+filename;
                File saveFile=new File(path);
                pfile.transferTo(saveFile);//上传

                //设置图片
                house.setPath(filename);


             }
             //2.调用业务
             houseService.updateHouse(house);
            if (!pfile.isEmpty()) {
                //删除旧图
                File file = new File("d:\\images\\" + oldpic);
                file.delete();
            }
            return "redirect:getUserHouse";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("delHouse")
    @ResponseBody
    public String delHouse(String id){
        //调用业务删除
        int temp=this.houseService.delHouse(id,1);
        return "{\"result\":"+temp+"}";
    }


    @RequestMapping("searchHouse")
    public String searchHouse(HouseCondition condition,Model model){
        //调用业务
        condition.setRows(5);  //页大小默认5条
        PageInfo<House> houses = houseService.getHouseByBroswer(condition);
        List<House> list = houses.getList();
        for(House attribute : list) {
            System.out.println(attribute);
        }

        //填充信息
        model.addAttribute("houses",houses);
        model.addAttribute("condition",condition);
        return "list";
    }
}
