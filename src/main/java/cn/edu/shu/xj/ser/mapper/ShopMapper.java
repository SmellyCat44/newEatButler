package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Shop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface ShopMapper extends BaseMapper<Shop> {
    @Select("select * from shop where shop_id =#{shop_id}")
    Shop findOneShopbyId(@Param("shop_id") String shopId);

    @Select("select shop_pwd from shop where shop_id =#{shop_id}")
    String findShopPwdbyId(@Param("shop_id") String shopId);

    @Select("select * from shop where shkper_tel =#{shkper_tel}")
    Shop findOneShopbyTel(@Param("shkper_tel") String shkperTel);

    @Select("select shop_pwd from shop where shkper_tel =#{shkper_tel}")
    String findShopPwdbyTel(@Param("shkper_tel") String shkperTel);
}
