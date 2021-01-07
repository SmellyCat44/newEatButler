package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Product;
import cn.edu.shu.xj.ser.entity.ProductType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductTypeMapper extends BaseMapper<ProductType> {
    @Select("select * from producttype where shop_id=#{shop_id}")
    List<ProductType> producttypelist(@Param("shop_id") String shopId);
}
