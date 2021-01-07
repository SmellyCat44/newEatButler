package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Custom;
import cn.edu.shu.xj.ser.entity.Student;
import cn.edu.shu.xj.ser.service.ICustomService;
import cn.edu.shu.xj.ser.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    ICustomService customService;

    @ApiOperation(value = "获取客户列表")
    @GetMapping("/list")
    public List<Custom> queryStudentAge(){
        List<Custom> ansList = customService.list();
        ansList.sort(Comparator.comparing(Custom::getLocation));
        return ansList;
    }

    @ApiOperation(value = "获取客户数量")
    @GetMapping("/count")
    public Integer count(){
        return customService.count();
    }

    @ApiOperation(value = "保存客户信息")
    @PostMapping("/save")
    public boolean save(Custom custom){
        return customService.saveOrUpdate(custom);
    }

}
