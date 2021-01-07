package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.OrderDetail;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.service.IOrderDetailService;
import cn.edu.shu.xj.ser.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    IUserService userService;


    //用户注册+修改个人信息
    @ApiOperation(value = "新增或修改相关数据")
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        //存在该id作修改
        //不存在该id或不传入，作新增操作
        return userService.saveOrUpdate(user);
    }

    //用户登陆
    //返回值
    //-1用户不存在
    //-2密码错误
    //1登陆成功
    @ApiOperation(value = "用户家通过账号密码登录")
    @PostMapping("/login/byId")
    public int loginbyId(@RequestParam(value = "user_id") String userId, @RequestParam(value = "user_pwd") String userPwd){
        User oneUser = userService.findOneUserbyId(userId);
        if(oneUser==null) return -1;//用户不存在
        else{
            if(oneUser.getUserPwd().equals(userPwd)) return 1;//登陆成功
            else return -2;//密码错误
        }
    }

    @ApiOperation(value = "用户通过手机号密码登录")
    @PostMapping("/login/byTel")
    public int loginbyTel(@RequestParam(value = "user_tel") String userTel, @RequestParam(value = "user_pwd") String userPwd){
        User oneUser = userService.findOneUserbyTel(userTel);
        if(oneUser==null) return -1;//用户手机号不存在
        else{
            if(oneUser.getUserPwd().equals(userPwd)) return 1;//登陆成功
            else return -2;//密码错误
        }
    }

    //管理员删除用户
    @ApiOperation(value = "删除相关数据")
    @PostMapping("/remove/byuserId")
    public boolean remove(@RequestParam(value = "user_id") String userId){
        return userService.removeById(userId);
    }

    //管理员查看用户列表
    @ApiOperation(value = "用户全列表")
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

}
