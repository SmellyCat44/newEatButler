package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Manager;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.service.IManagerService;
import cn.edu.shu.xj.ser.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.tools.jconsole.inspector.IconManager;

import java.util.List;

@Api(tags = "管理员模块")
@RestController
@RequestMapping("/manager")
@CrossOrigin
public class ManagerController {

    @Autowired
    IManagerService managerService;

    //管理员查看用户列表
    @ApiOperation(value = "管理员登陆")
    @GetMapping("/login")
    public int login(@RequestParam(value = "manager_id") String managerId, @RequestParam(value = "manager_pwd") String managerPwd){
        Manager oneManager = managerService.findOneManager(managerId);
        if(oneManager==null) return -1;
        else{
            if (oneManager.getManagerPwd().equals(managerPwd)) return 1;
            else return -2;
        }
    }
}