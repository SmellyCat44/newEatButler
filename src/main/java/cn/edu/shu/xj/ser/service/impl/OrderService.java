package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.mapper.OrderMapper;
import cn.edu.shu.xj.ser.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    OrderMapper orderMapper;

    public int ridertakeorder(Integer oId, String riderId, Date date){
        return orderMapper.ridertakeorder(oId,riderId,date);
    }
    public double riderbalance(String riderId){
        return orderMapper.riderbalance(riderId);
    }
    public List<Order> riderTask(String riderId){
        return orderMapper.riderTask(riderId);
    }
    public List<Order> riderRecord(String riderId){
        return orderMapper.riderRecord(riderId);
    }
    public int riderConfirm(Integer oId,Date date){
        return orderMapper.riderConfirm(oId,date);
    }

//    public int userconfirmorder(String orderId){
//        return orderMapper.userconfirmorder(orderId);
//    }
//    public int usercancel(String orderId){
//        return orderMapper.usercancel(orderId);
//    }
    public List<Order> userorder(String userId){
        return orderMapper.userorder(userId);
    }
    public List<Order> shoporder(String shopId){
        return orderMapper.shoporder(shopId);
    }
    public List<Order> riderlistall(String riderId){
        return orderMapper.riderlistall(riderId);
    }
    public List<Order> riderjiedan(){
        return orderMapper.riderjiedan();
    }

    public boolean shopmoney(Integer orderId){
        return orderMapper.shopmoney(orderId);
    }
    public boolean ridermoney(Integer orderId){
        return orderMapper.ridermoney(orderId);
    }
    public int ridermoney1(Integer orderId){
        return orderMapper.ridermoney1(orderId);
    }
    public int shopmoney1(Integer orderId){
        return orderMapper.shopmoney1(orderId);
    }

    public double shopBalance(String shopId){
        return orderMapper.shopBalance(shopId);
    }
    public Order riderjiedanDetail(Integer oId){
        return orderMapper.riderjiedanDetail(oId);
    }

    public int createOrder(String shopId, String userId){
        return orderMapper.createOrder(shopId,userId);
    }
    public List<Order> getOrderList(){
        return orderMapper.getOrderList();
    }
    public boolean doneOrder(Integer orderId, Integer addressId,double sum){
        return orderMapper.doneOrder(orderId,addressId,sum);
    }
    public double sumMoney(Integer orderId){
        return orderMapper.sumMoney(orderId);
    }

    public String isVip(String userId){
        return orderMapper.isVip(userId);
    }

    public boolean updateMon(Integer orderId){
        return orderMapper.updateMon(orderId);
    }

    public boolean userPay(String userId,double sum){
        return orderMapper.userPay(userId,sum);
    }

    public Order findOrder(Integer orderId){
        return orderMapper.findOrder(orderId);
    }

    public String findStatus(Integer orderId){
        return orderMapper.findStatus(orderId);
    }

    public void dealOrder(Integer orderId){
        orderMapper.dealOrder(orderId);
    }

    public List<Order> deliveryOrder(String userId){
        return orderMapper.deliveryOrder(userId);
    }

    public void userConfirm(Integer orderId){
        orderMapper.userConfirm(orderId);
    }

    public List<Order> userRecord(String userId){
        return orderMapper.userRecord(userId);
    }
}