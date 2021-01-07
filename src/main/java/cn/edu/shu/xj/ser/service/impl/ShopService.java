package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Shop;
import cn.edu.shu.xj.ser.mapper.ShopMapper;
import cn.edu.shu.xj.ser.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService extends ServiceImpl<ShopMapper, Shop> implements IShopService {
    @Autowired
    ShopMapper shopMapper;

    public Shop findOneShopbyId(String shopId){ return shopMapper.findOneShopbyId(shopId); }
    public Shop findOneShopbyTel(String skpTel){ return shopMapper.findOneShopbyTel(skpTel); }

    public String findShopPwdbyId(String shopId){ return shopMapper.findShopPwdbyId(shopId); }
    public String findShopPwdbyTel(String skpTel){ return shopMapper.findShopPwdbyTel(skpTel); }
}
