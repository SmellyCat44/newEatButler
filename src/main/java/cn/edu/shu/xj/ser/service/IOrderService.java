package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IOrderService extends IService<Order> {
    public int ridertakeorder(Integer oId, String riderId, Date date);

    public double riderbalance(String riderId);

    public List<Order> riderRecord(String riderId);

    public List<Order> riderTask(String riderId);

    public int riderConfirm(Integer oId,Date date);

//    public int userconfirmorder(Integer orderId);

//    public int usercancel(Integer orderId);

    public List<Order> userorder(String userId);

    public List<Order> shoporder(String shopId);

    public List<Order> riderlistall(String riderId);

    public List<Order> riderjiedan();

    public boolean shopmoney(Integer orderId);

    public boolean ridermoney(Integer orderId);

    public int ridermoney1(Integer orderId);

    public int shopmoney1(Integer orderId);

    public double shopBalance(String shopId);

    public Order riderjiedanDetail(Integer oId);

    public int createOrder(String shopId, String userId);

    public List<Order> getOrderList();

    public boolean doneOrder(Integer orderId,Integer addressId,double sum);

    public double sumMoney(Integer orderId);

    public String isVip(String userId);

    public boolean updateMon(Integer orderId);

    public boolean userPay(String userId,double sum);

    public Order findOrder(Integer orderId);

    public String findStatus(Integer orderId);

    public void dealOrder(Integer orderId);

    public List<Order> deliveryOrder(String userId);

    public void userConfirm(Integer orderId);

    public List<Order> userRecord(String userId);
}
