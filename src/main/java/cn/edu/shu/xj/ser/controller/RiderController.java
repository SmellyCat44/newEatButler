package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Rider;
import cn.edu.shu.xj.ser.entity.Shop;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.service.IRiderService;
import cn.edu.shu.xj.ser.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "骑手模块")
@RestController
@RequestMapping("/rider")
@CrossOrigin
public class RiderController {

    @Autowired
    IRiderService riderService;


    //骑手注册+修改个人信息
    @ApiOperation(value = "新增或修改相关数据")
    @PostMapping("/save")
    public boolean save(@RequestBody Rider rider){
        return riderService.saveOrUpdate(rider);
    }

    //管理员删除骑手
    @ApiOperation(value = "删除相关数据")
    @PostMapping("/remove/byriderId")
    public boolean remove(@RequestParam(value = "rider_id") String riderId){
        return riderService.removeById(riderId);
    }

    //管理员查看骑手列表
    @ApiOperation(value = "骑手全列表")
    @GetMapping("/list")
    public List<Rider> list(){
        return riderService.list();
    }

    //骑手登陆
    //返回值
    //-1骑手不存在
    //-2密码错误
    //1登陆成功
    @ApiOperation(value = "骑手通过账号密码登录")
    @PostMapping("/login/byId")
    public int loginbyId(@RequestParam(value = "rider_id") String riderId, @RequestParam(value = "rider_pwd") String riderPwd){
        Rider oneRider = riderService.findOneRiderbyId(riderId);
        if(oneRider==null) return -1;//骑手不存在
        else{
            if(oneRider.getRiderPwd().equals(riderPwd)) return 1;//登陆成功
            else return -2;//密码错误
        }
    }

    @ApiOperation(value = "骑手通过手机号密码登录")
    @PostMapping("/login/byTel")
    public int loginbyTel(@RequestParam(value = "rider_tel") String riderTel, @RequestParam(value = "rider_pwd") String riderPwd){
        Rider oneRider = riderService.findOneRiderbyTel(riderTel);
        if(oneRider==null) return -1;//骑手不存在
        else{
            if(oneRider.getRiderPwd().equals(riderPwd)) return 1;//登陆成功
            else return -2;//密码错误
        }
    }
}
