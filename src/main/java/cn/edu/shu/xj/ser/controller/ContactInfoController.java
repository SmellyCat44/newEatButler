package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.ContactInfo;
import cn.edu.shu.xj.ser.entity.Custom;
import cn.edu.shu.xj.ser.service.IContactInfoService;
import cn.edu.shu.xj.ser.service.ICustomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/contactinfo")
public class ContactInfoController {

    @Autowired
    IContactInfoService contactInfoService;

    @ApiOperation(value = "获取联系人列表")
    @GetMapping("/list")
    public List<ContactInfo> list(){
        return contactInfoService.list();
    }

    @ApiOperation(value = "获取联系人数量")
    @GetMapping("/count")
    public Integer count(){
        return contactInfoService.count();
    }

    @ApiOperation(value = "保存联系人信息")
    @PostMapping("/save")
    public boolean save(ContactInfo contactInfo){
        return contactInfoService.saveOrUpdate(contactInfo);
    }

}
