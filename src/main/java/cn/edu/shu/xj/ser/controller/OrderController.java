package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.entity.OrderDetail;
import cn.edu.shu.xj.ser.entity.Product;
import cn.edu.shu.xj.ser.entity.ShopAccount;
import cn.edu.shu.xj.ser.service.IOrderDetailService;
import cn.edu.shu.xj.ser.service.IAddressService;
import cn.edu.shu.xj.ser.service.IOrderService;
import cn.edu.shu.xj.ser.service.impl.OrderDetailService;
import com.sun.tools.corba.se.idl.constExpr.Or;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = "订单模块")
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    IOrderService orderService;

    //管理员用
    @ApiOperation(value = "订单全列表")
    @GetMapping("/list")
    public List<Order> list() {
        return orderService.list();
    }

    //骑手接单
    @ApiOperation(value = "骑手接单")
    @PostMapping("/rider/take")
    public int ridertakeorder(@RequestParam(value = "o_id")Integer oId,@RequestParam(value = "rider_id")String riderId) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        orderService.ridertakeorder(oId,riderId,date);
        return 1;//接单成功返回1
    }

    //用户取消订单
//    @ApiOperation(value = "用户取消订单")
//    @PostMapping("/user/cancel")
//    public int usercancel(@RequestParam(value = "o_id")String orderId){
//        orderService.usercancel(orderId);
//        return 1;//取消成功返回1
//    }

    //用户确认收货同时商家和骑手产生收益
//    @ApiOperation(value = "用户确认收货同时商家和骑手产生收益")
//    @PostMapping("/user/confirm")
//    public int userconfirmorder(@RequestParam(value = "o_id")String orderId){
//        orderService.userconfirmorder(orderId);
//        orderService.ridermoney(orderId);//骑手收益函数
//        orderService.ridermoney1(orderId);
//        orderService.shopmoney(orderId);//商家收益函数
//        return orderService.shopmoney1(orderId);
//    }

    //用户查看个人订单
    @ApiOperation(value = "用户查看个人订单")
    @GetMapping("/user/list")
    public List<Order> userorder(@RequestParam(value = "user_id") String userId){
        return orderService.userorder(userId);
    }

    //商家查看个人订单
    @ApiOperation(value = "商家查看个人订单")
    @GetMapping("/shop/list")
    public List<Order> shoplist(@RequestParam(value = "shop_id")String shopId){
        return orderService.shoporder(shopId);
    }

    //骑手查看个人订单
    @ApiOperation(value = "骑手查看个人订单")
    @GetMapping("/rider/listall")
    public List<Order> riderlistall(@RequestParam(value = "rider_id")String riderId){
        return orderService.riderlistall(riderId);
    }

    //骑手查看可接订单
    @ApiOperation(value = "骑手查看可接订单")
    @GetMapping("/rider/jiedan")
    public List<Order> riderjiedan(){
        return orderService.riderjiedan();
    }

    //骑手查看订单详情
    @ApiOperation(value = "骑手查看订单详情")
    @PostMapping("/rider/jiedan/detail")
    public Order riderjiedanDetail(@RequestParam(value = "o_id")Integer oId){
        return orderService.riderjiedanDetail(oId);
    }

    @ApiOperation(value = "骑手查看钱包")
    @PostMapping("rider/balance")
    public double riderbalance(@RequestParam(value = "rider_id")String riderId){
        return orderService.riderbalance(riderId);
    }

    @ApiOperation(value = "骑手查看任务订单")
    @PostMapping("rider/task")
    public List<Order> riderTask(@RequestParam(value = "rider_id")String riderId){
        return orderService.riderTask(riderId);
    }

    @ApiOperation(value = "骑手确认送达")
    @PostMapping("rider/confirm")
    public int riderConfirm(@RequestParam(value = "o_id")Integer orderId){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        orderService.riderConfirm(orderId,date);
        return 1;
    }

    @ApiOperation(value = "骑手查看历史（已送达）订单")
    @PostMapping("rider/record")
    public List<Order> riderRecord(@RequestParam(value = "rider_id")String riderId){
        return orderService.riderRecord(riderId);
    }

    //商家查看钱包
    @ApiOperation(value = "商家查看钱包金额")
    @GetMapping("/shop/balance")
    public double shopBalance(@RequestParam(value = "shop_id")String shopId){
        return orderService.shopBalance(shopId);
    }

    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
    public int createOrder(@RequestParam(value = "shop_id")String shopId,@RequestParam(value = "user_id") String userId){
        orderService.createOrder(shopId,userId);
        List<Order> orders = orderService.getOrderList();
        return orders.get(0).getOId();//返回当前订单号
    }

    @ApiOperation(value = "确认下单")
    @PostMapping("/done")
    public Order doneOrder(@RequestParam(value = "o_id") Integer orderId,
                         @RequestParam(value = "user_id") String userId,
                         @RequestParam(value = "address_id") Integer addressId){
        double sum = 0;
        sum = orderService.sumMoney(orderId);
        String isVIP = "";
        orderService.doneOrder(orderId,addressId,sum);
        isVIP = orderService.isVip(userId);
        if(isVIP.equals("是")){
            orderService.updateMon(orderId);
        }
        boolean flag = orderService.userPay(userId,sum);
        if(flag) orderService.dealOrder(orderId);
        String nowStatus =  "";
        nowStatus = orderService.findStatus(orderId);
        if(nowStatus.equals("已下单")) return orderService.findOrder(orderId);
        else return null;
    }

    @ApiOperation(value = "用户查看正在配送订单")
    @PostMapping("/user/check")
    public List<Order> deliveryOrder(@RequestParam(value = "user_id") String userId){
        return orderService.deliveryOrder(userId);
    }

    @ApiOperation(value = "用户确认收货")
    @PostMapping("user/confirm")
    public int userConfirmOrder(@RequestParam(value = "o_id") Integer orderId){
        String nowStatus =  "";
        nowStatus = orderService.findStatus(orderId);
        if(nowStatus.equals("正在配送")) return -2;
        else {
            orderService.userConfirm(orderId);//改订单状态
            orderService.ridermoney(orderId);
            orderService.ridermoney1(orderId);//骑手入账
            orderService.shopmoney(orderId);
            orderService.shopmoney1(orderId);//商家入账
            return 1;
        }
    }

    @ApiOperation(value = "用户查看历史订单")
    @PostMapping("user/record")
    public List<Order> userRecord(@RequestParam(value = "user_id") String userId){
        return orderService.userRecord(userId);
    }


}