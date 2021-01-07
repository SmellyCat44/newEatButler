package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Rider;
import cn.edu.shu.xj.ser.entity.ShopAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShopAccountMapper extends BaseMapper<ShopAccount> {
    @Select("select * from shop_account where shop_id=#{shop_id}")
    List<ShopAccount> shopBalanceDetail(@Param("shop_id") String shopId);
}
