package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
public interface ProductMapper extends BaseMapper<Product> {
//    @Update("update products set product_name =#{product_name},product_price =#{product_price}")
//    boolean changeProduct(@RequestBody Product product);
    @Select("select * from products where p_id=#{p_id}")
    Product productdetaibyId(@Param("p_id") String productId);

    @Select("select product_price from products where p_id=#{p_id}")
    double findPrice(@Param("p_id") Integer productId);

    @Select("select * from products where shop_id=#{shop_id}")
    List<Product> productlist(@Param("shop_id") String shopId);
}
