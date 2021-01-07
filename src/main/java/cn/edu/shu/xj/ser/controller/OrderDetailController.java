package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.entity.OrderDetail;
import cn.edu.shu.xj.ser.entity.Product;
import cn.edu.shu.xj.ser.entity.ProductType;
import cn.edu.shu.xj.ser.service.IProductService;
import cn.edu.shu.xj.ser.service.IOrderDetailService;
import com.sun.tools.corba.se.idl.constExpr.Or;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "购物车模块")
@RestController
@RequestMapping("/go")
@CrossOrigin
public class OrderDetailController {
    @Autowired
    IOrderDetailService orderDetailService;

    //用户下单
    @ApiOperation(value = "用户下单")
    @PostMapping("/order")
    public boolean findPrice(@RequestParam(value = "o_id") Integer orderId,@RequestParam(value = "user_id") String userId,
                             @RequestParam(value = "address_id") Integer addressId){
        orderDetailService.createorder(orderId);
        return orderDetailService.xiadan(userId,addressId,orderId);
    }

    @ApiOperation(value = "用户加入购物车")
    @PostMapping("/add")
    public int addCart(@RequestParam(value = "o_id") Integer orderId,
                       @RequestParam(value = "product_id") Integer productId,
                       @RequestParam(value = "final_price")Double finalPrice){
        OrderDetail oneorderdetail = orderDetailService.findproduct(orderId,productId);
        if (oneorderdetail==null){
            orderDetailService.insertCart(orderId,productId,finalPrice);
        }
        else{
            orderDetailService.addCart(orderId,productId,finalPrice);
        }
        return 1;
    }

    @ApiOperation(value = "用户购物车中的商品-1")
    @PostMapping("/delete/oneproduct")
    public int deleteCart(@RequestParam(value = "o_id") Integer orderId,
                          @RequestParam(value = "product_id") Integer productId,
                          @RequestParam(value = "final_price")Double finalPrice){
        OrderDetail oneorderdetail = orderDetailService.findproduct(orderId,productId);
        if(oneorderdetail==null) return -1;
        else{
            orderDetailService.deleteOneProduct(orderId,productId,finalPrice);
            return 1;
        }
    }

    @ApiOperation(value = "删除购物车中的一种商品")
    @PostMapping("/delete/allproduct")
    public int deleteCart(@RequestParam(value = "o_id") Integer orderId,
                          @RequestParam(value = "product_id") Integer productId){
        OrderDetail oneorderdetail = orderDetailService.findproduct(orderId,productId);
        if(oneorderdetail==null) return -1;
        else {
            orderDetailService.deleteAllProduct(orderId,productId);
            return 1;
        }
    }

    @ApiOperation(value = "用户删除购物车")
    @PostMapping("/remove")
    public boolean remove(@RequestParam(value = "o_id") Integer orderId){
        return orderDetailService.removeById(orderId);
    }

    @ApiOperation(value = "用户查看购物车")
    @PostMapping("/list")
    public List<OrderDetail> userCart(@RequestParam(value = "o_id") Integer orderId){
        return orderDetailService.userCart(orderId);
    }

}
