package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface OrderMapper extends BaseMapper<Order> {
    @Update("update orders set rider_id=#{rider_id},order_status='正在配送',take_time=#{date} where o_id=#{o_id} and order_status='已下单'")
    public int ridertakeorder(@Param("o_id") Integer oId, @Param("rider_id") String riderId, Date date);


    @Update("update orders set order_status='已送达',arrive_time=#{date} where o_id=#{o_id} and order_status='正在配送'")
    public int riderConfirm(@Param("o_id")Integer orderId, Date date);

    @Select("select * from orders where order_status='确认收货' and rider_id=#{rider_id}")
    public List<Order> riderRecord(@Param("rider_id")String riderId);

    @Update("update orders set order_status='确认收货' where o_id=#{o_id} and order_status='正在配送'")
    public int userconfirmorder(@Param("o_id")String orderId);

    @Update("update orders set order_status='已取消' where o_id=#{o_id} and order_status='已下单'")
    public int usercancel(@Param("o_id")Integer orderId);

    @Select("select * from orders where user_id=#{user_id}")
    public List<Order> userorder(@Param("user_id")String userId);

    @Select("select * from orders where shop_id=#{shop_id}")
    public List<Order> shoporder(@Param("shop_id")String shopId);

    @Select("select * from orders where rider_id=#{rider_id}")
    public List<Order> riderlistall(@Param("rider_id")String riderId);

    @Select("select a.o_id,c.shop_address,b.province,b.city,b.region,b.address\n" +
            "from orders a,addrinfo b, shop c\n" +
            "where order_status='已下单' and b.address_id=a.address_id and c.shop_id=a.shop_id")
    public List<Order> riderjiedan();

    @Select("select a.o_id,a.order_time,c.shop_name,c.shkper_tel,b.linkman,b.tel\n" +
            "from orders a,addrinfo b, shop c\n" +
            "where b.address_id=a.address_id and c.shop_id=a.shop_id and a.o_id=#{o_id}")
    public Order riderjiedanDetail(Integer oId);

    @Select("select a.o_id,c.shop_address,c.shkper_tel,b.province,b.city,b.region,b.address,b.linkman,b.tel,a.order_status\n" +
            "from orders a,addrinfo b, shop c\n" +
            "where order_status='正在配送' and b.address_id=a.address_id and c.shop_id=a.shop_id and rider_id=#{rider_id}\n"+
            "order by a.take_time")
    public List<Order> riderTask(@Param("rider_id")String riderId);

    @Select("select sum(r_income) from rider_account where rider_id=#{rider_id}")
    public double riderbalance(@Param("rider_id")String riderId);
    //商家受益记录
    @Insert("insert into shop_account(o_id,shop_id,s_income)\n" +
            "select orders.o_id,orders.shop_id,0.6*orders.row\n" +
            "from orders\n" +
            "where o_id=#{o_id}\n")
    public boolean shopmoney(@Param("o_id")Integer orderId);
    @Update("update shop_account set s_time=now() where o_id=#{o_id}")
    public int shopmoney1(@Param("o_id")Integer orderId);

    //骑手收益记录
    @Insert("insert into rider_account(o_id,rider_id)\n" +
            "select orders.o_id,orders.rider_id\n" +
            "from orders\n" +
            "where o_id=#{o_id}\n")
    public boolean ridermoney(@Param("o_id")Integer orderId);
    @Update("update rider_account set r_income=6,r_acc_time=now() where o_id=#{o_id}")
    public int ridermoney1(@Param("o_id")Integer orderId);

    @Select("select SUM(s_income) from shop_account where shop_id=#{shop_id}")
    Double shopBalance(@Param("shop_id") String shopId);

    @Insert("insert into orders(user_id,shop_id,order_status) values(#{user_id},#{shop_id},'正在点单')")
    public int createOrder(@Param("shop_id") String shopId,@Param("user_id")String userId);

    @Select("select * from orders order by o_id DESC")
    public List<Order> getOrderList();

    @Update("update orders set address_id=#{address_id},order_time=now(),row=#{sum},mon=#{sum} where o_id=#{o_id}")
    public boolean doneOrder(@Param("o_id")Integer orderId,@Param("address_id")Integer addressId,double sum);

    @Select("select sum(final_price) from orderdetail where o_id=#{o_id}")
    public double sumMoney(@Param("o_id")Integer orderId);

    @Select("select is_vip from users where user_id=#{user_id}")
    public String isVip(@Param("user_id")String userId);

    @Update("update orders set mon=mon*0.9 where o_id=#{o_id}")
    public boolean updateMon(@Param("o_id")Integer orderId);

    @Update("update users set user_balance=user_balance-#{sum} where user_id=#{user_id} and user_balance>=#{sum}")
    public boolean userPay(@Param("user_id")String userId,double sum);

    @Select("select a.o_id,a.order_time,a.user_id,c.shop_name,b.linkman,b.province,b.city,b.region,b.address,b.tel,a.mon\n" +
            "from orders a, addrinfo b,shop c\n" +
            "where a.o_id=#{o_id} and a.address_id=b.address_id and c.shop_id=a.shop_id")
    public Order findOrder(@Param("o_id")Integer orderId);

    @Select("select order_status from orders where o_id=#{o_id}")
    public String findStatus(@Param("o_id")Integer orderId);

    @Update("update orders set order_status='已下单' where o_id=#{o_id}")
    public void dealOrder(@Param("o_id")Integer orderId);

    @Select("select * from orders where user_id=#{user_id} and order_status='正在配送' or order_status='已送达'")
    public List<Order> deliveryOrder(@Param("user_id")String userId);

    @Update("update orders set order_status='确认收货' where o_id=#{o_id}")
    public void userConfirm(@Param("o_id")Integer orderId);

    @Select("select * from orders where user_id=#{user_id} and order_status='确认收货' order by order_time desc")
    public List<Order> userRecord(@Param("user_id")String userId);
}
