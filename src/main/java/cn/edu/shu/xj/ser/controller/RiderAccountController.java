package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.RiderAccount;
import cn.edu.shu.xj.ser.service.IRiderAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商家入账模块")
@RestController
@RequestMapping("/rideraccount")
@CrossOrigin
public class RiderAccountController {

    @Autowired
    IRiderAccountService riderAccountService;

    @ApiOperation(value = "商家查看钱包明细")
    @GetMapping("/detail")
    public List<RiderAccount> riderBalanceDetail(@RequestParam(value = "rider_id")String riderId){
        return riderAccountService.riderBalanceDetail(riderId);
    }
}
