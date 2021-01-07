package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.ShopAccount;
import cn.edu.shu.xj.ser.service.IShopAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商家入账模块")
@RestController
@RequestMapping("/shopaccount")
@CrossOrigin
public class ShopAccountController {

    @Autowired
    IShopAccountService shopAccountService;

    @ApiOperation(value = "商家查看钱包明细")
    @GetMapping("/detail")
    public List<ShopAccount> shopBalanceDetail(@RequestParam(value = "shop_id")String shopId){
        return shopAccountService.shopBalanceDetail(shopId);
    }
}
