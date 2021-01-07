package cn.edu.shu.xj.ser.service.impl;


import cn.edu.shu.xj.ser.entity.OrderDetail;
import cn.edu.shu.xj.ser.mapper.OrderDetailMapper;
import cn.edu.shu.xj.ser.service.IOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {
    @Autowired
    OrderDetailMapper orderDetailMapper;

    public boolean add(Integer productId, Integer amt,Double finalPrice) {
        return orderDetailMapper.add(productId, amt, finalPrice);
    }
    public int modifyamt(Integer orderId, Integer amt,Double finalPrice){
        return orderDetailMapper.modifyamt(amt,finalPrice,orderId);
    }

    public int getpd(Integer orderId){
        return orderDetailMapper.getpd(orderId);
    }

    public boolean createorder(Integer orderId){
        return orderDetailMapper.createorder(orderId);
    }

    public boolean xiadan(String userId,Integer addressId,Integer orderId){
        return orderDetailMapper.xiadan(userId,addressId,orderId);
    }

    public OrderDetail findproduct(Integer orderId, Integer productId){
        return orderDetailMapper.findproduct(orderId,productId);
    }

    public int insertCart(Integer orderId,Integer productId,Double finalPrice){
        return orderDetailMapper.insertCart(orderId,productId,finalPrice);
    }

    public int addCart(Integer orderId,Integer productId,Double finalPrice){
        return orderDetailMapper.addCart(orderId,productId,finalPrice);
    }

    public int deleteOneProduct(Integer orderId,Integer productId,Double finalPrice){
        return orderDetailMapper.deleteOneProduct(orderId,productId,finalPrice);
    }

    public int deleteAllProduct(Integer orderId,Integer productId){
        return orderDetailMapper.deleteAllProduct(orderId,productId);
    }

    public List<OrderDetail> userCart(Integer orderId){
        return orderDetailMapper.userCart(orderId);
    }



}
