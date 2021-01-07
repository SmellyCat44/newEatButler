package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Address;
import cn.edu.shu.xj.ser.entity.Manager;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.service.IAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户地址模块")
@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    IAddressService addressService;

    //用户添加地址或修改地址
    @ApiOperation(value = "用户添加或修改地址")
    @PostMapping("/save")
    public boolean save(@RequestBody Address address){
        return addressService.saveOrUpdate(address);
    }

    @ApiOperation(value = "用户删除地址")
    @PostMapping("/remove/byaddressId")
    public boolean remove(@RequestParam(value = "address_id") String addressId){
        return addressService.removeById(addressId);
    }

    @ApiOperation(value = "用户地址全列表")
    @GetMapping("/list")
    public List<Address> list(@RequestParam(value = "user_id") String userId) {
        return addressService.userlist(userId);
    }
}