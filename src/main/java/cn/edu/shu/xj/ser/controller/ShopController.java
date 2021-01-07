package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Shop;
import cn.edu.shu.xj.ser.service.IShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商家模块")
@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    @Autowired
    IShopService shopService;

    //商家注册+修改个人信息
    @ApiOperation(value = "新增或修改相关数据")
    @PostMapping("/save")
    public boolean save(@RequestBody Shop shop){
        return shopService.saveOrUpdate(shop);
    }

    //商家登陆
    //返回值
    //-1商家不存在
    //-2密码错误
    //1登陆成功
    @ApiOperation(value = "商家通过账号密码登录")
    @GetMapping("/login/byId")
    public int loginbyId(@RequestParam(value = "shop_id") String shopId, @RequestParam(value = "shop_pwd") String shopPwd){
        Shop oneShop = shopService.findOneShopbyId(shopId);
        if(oneShop==null) return -1;//商家不存在
        else{
            if(oneShop.getShopPwd().equals(shopPwd)) return 1;//登陆成功
            else return -2;//密码错误
        }
    }

    @ApiOperation(value = "商家通过手机号密码登录")
    @GetMapping("/login/byTel")
    public int loginbyTel(@RequestParam(value = "shkper_tel") String shkperTel, @RequestParam(value = "shop_pwd") String shopPwd){
        Shop oneShop = shopService.findOneShopbyTel(shkperTel);
        if(oneShop==null) return -1;//商家手机号不存在
        else{
            if(oneShop.getShopPwd().equals(shopPwd)) return 1;//登陆成功
            else return -2;//密码错误
        }
    }

    //管理员查看商家列表
    @ApiOperation(value = "商家全列表")
    @GetMapping("/list")
    public List<Shop> list(){
        return shopService.list();
    }

    //管理员删除商家
    @ApiOperation(value = "删除相关数据")
    @PostMapping("/remove/byshopId")
    public boolean remove(@RequestParam(value = "shop_id") String shopId){
        return shopService.removeById(shopId);
    }
}