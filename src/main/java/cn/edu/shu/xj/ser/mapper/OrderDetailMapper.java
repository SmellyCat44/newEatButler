package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.entity.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

    @Insert("insert into orderdetail(product_id,amt,final_price,dsc_sig) values(#{product_id},#{amt},#{final_price},0)")
    public boolean add(@Param("product_id")Integer productId, @Param("amt")Integer amt,@Param("final_price")Double finalPrice);

    @Update("update orderdetail set amt=#{amt},final_price=#{final_price} where o_id=#{o_id}")
    public int modifyamt(@Param("amt")Integer amt, @Param("final_price") Double finalPrice, @Param("o_id")Integer  orderId);

    @Select("select product_id from orderdetail where o_id=#{o_id}")
    public int getpd(@Param("o_id")Integer orderId);

    //下单
    @Insert("insert into orders(o_id,shop_id,row,mon)\n" +
            "SELECT orderdetail.o_id,shop_id,final_price,final_price\n" +
            "from orderdetail,products,producttype\n" +
            "where o_id=#{o_id} and products.p_id=orderdetail.product_id and products.type_id=producttype.type_id")
    public boolean createorder(@Param("o_id") Integer orderId);
    @Update("update orders set order_status='已下单',user_id=#{user_id},address_id=#{address_id} where o_id=#{o_id}")
    public boolean xiadan(@Param("user_id") String userId,@Param("address_id")Integer addressId,@Param("o_id")Integer orderId);

    @Select("select * from orderdetail where o_id=#{o_id} and product_id=#{product_id}")
    public OrderDetail findproduct(@Param("o_id") Integer orderId,@Param("product_id") Integer productId);

    @Insert("insert into orderdetail(o_id,product_id,amt,final_price) values(#{o_id},#{product_id},1,#{final_price})")
    public int insertCart(@Param("o_id") Integer orderId,@Param("product_id") Integer productId,@Param("final_price")Double final_price);

    @Update("update orderdetail set amt=amt+1,final_price=final_price+#{final_price} where o_id=#{o_id} and product_id=#{product_id}")
    public int addCart(@Param("o_id") Integer orderId,@Param("product_id") Integer productId,@Param("final_price")Double final_price);

    @Update("update orderdetail set amt=amt-1,final_price=final_price-#{final_price} where o_id=#{o_id} and product_id=#{product_id}")
    public int deleteOneProduct(@Param("o_id") Integer orderId,@Param("product_id") Integer productId,@Param("final_price")Double final_price);

    @Delete("delete from orderdetail where o_id=#{o_id} and product_id=#{product_id}")
    public int deleteAllProduct(@Param("o_id") Integer orderId,@Param("product_id") Integer productId);

    @Select("select a.o_id,a.product_id,b.product_name,a.amt,a.final_price from orderdetail a,products b where o_id=#{o_id} and a.product_id=b.p_id")
    public List<OrderDetail> userCart(@Param("o_id") Integer orderId);


}
